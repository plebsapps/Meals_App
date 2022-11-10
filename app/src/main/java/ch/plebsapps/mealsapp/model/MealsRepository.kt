package ch.plebsapps.mealsapp.model

import ch.plebsapps.mealsapp.model.api.MealsWebService
import ch.plebsapps.mealsapp.model.response.MealsCategoriesResponse
import ch.plebsapps.mealsapp.model.response.MealsResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    private var cachedMeals = listOf<MealsResponse>()

    suspend fun getMeals(): MealsCategoriesResponse {
        val response = webService.getMeals()
        cachedMeals = response.categories
        return response
    }

    fun getMeal(id: String): MealsResponse? {
        return cachedMeals.firstOrNull {
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: MealsRepository? = null
        fun getInstance() = instance?: synchronized(this) {
            instance ?: MealsRepository().also {instance = it}
        }
    }
}