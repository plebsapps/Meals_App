package ch.plebsapps.mealsapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ch.plebsapps.mealsapp.ui.meals.MealsCategoriesScreen
import ch.plebsapps.mealsapp.ui.theme.MealsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MealsAppTheme {
                MealsCategoriesScreen()
            }
        }
    }
}