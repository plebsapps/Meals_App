package ch.plebsapps.mealsapp.ui.meals

import androidx.lifecycle.ViewModel
import ch.plebsapps.mealsapp.model.MealsRepository
import ch.plebsapps.mealsapp.model.response.MealsCategoriesResponse
import ch.plebsapps.mealsapp.model.response.MealsResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository() ) : ViewModel() {
    fun getMeals(successCallback:(response: MealsCategoriesResponse?) -> Unit) {
        repository.getMeals(){ response ->
            successCallback(response)
        }
    }
}