package ch.plebsapps.mealsapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import ch.plebsapps.mealsapp.ui.theme.MealsAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import ch.plebsapps.mealsapp.model.response.MealsResponse


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

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val remeberedMeals: MutableState<List<MealsResponse>> = remember { mutableStateOf(emptyList<MealsResponse>()) }

    viewModel.getMeals{ response ->
        val mealsFromTheApi = response?.categories
        remeberedMeals.value = mealsFromTheApi.orEmpty()
    }
    LazyColumn {
        items(remeberedMeals.value) { meal ->
            Text(text = meal.name)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealsAppTheme {
        MealsCategoriesScreen()
    }
}