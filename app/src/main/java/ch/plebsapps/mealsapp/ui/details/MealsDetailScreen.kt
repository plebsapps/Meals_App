package ch.plebsapps.mealsapp.ui.details


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import ch.plebsapps.mealsapp.model.response.MealsResponse
import ch.plebsapps.mealsapp.ui.meals.MealsCategoriesScreen
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation

@Composable
fun MealDetailsScreen(meal: MealsResponse?){
    Column {
        Row() {
            Card() {
                Image (
                    painter = rememberImagePainter(
                        data = meal?.imageUrl,
                        builder = {
                            transformations(CircleCropTransformation())
                    }),
                    contentDescription = "Image",
                    modifier = Modifier.size(200.dp)
            )
            }
            Text(text = meal?.name?: "default name")

        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Change state of meal profile picture")
        }
    }
}