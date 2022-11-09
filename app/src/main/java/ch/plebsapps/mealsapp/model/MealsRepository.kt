package ch.plebsapps.mealsapp.model

import ch.plebsapps.mealsapp.model.api.MealsWebService
import ch.plebsapps.mealsapp.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}