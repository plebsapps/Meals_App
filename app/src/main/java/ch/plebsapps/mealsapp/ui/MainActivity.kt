package ch.plebsapps.mealsapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ch.plebsapps.mealsapp.ui.details.MealDetailsScreen
import ch.plebsapps.mealsapp.ui.details.MealsDetailViewModel
import ch.plebsapps.mealsapp.ui.meals.MealsCategoriesScreen
import ch.plebsapps.mealsapp.ui.theme.MealsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MealsAppTheme {
                FoodiezApp()
            }
        }
    }
}

@Composable
private fun FoodiezApp(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = "destination_meals_list") {
        composable(route = "destination_meals_list") {
            MealsCategoriesScreen {navigationMealId ->
                navController.navigate("destination_meals_details/$navigationMealId")
            }
        }
        composable(route = "destination_meals_details/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id") {
                type = NavType.StringType
            })
        ) {
            val viewModle: MealsDetailViewModel = viewModel()
            MealDetailsScreen(
                viewModle.mealState.value
            )
        }
    }
}