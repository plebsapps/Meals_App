package ch.plebsapps.mealsapp.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ch.plebsapps.mealsapp.model.MealsRepository
import ch.plebsapps.mealsapp.model.response.MealsResponse

class MealsDetailViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val repository: MealsRepository = MealsRepository.getInstance()

    var mealState = mutableStateOf<MealsResponse?>(null)

    init{
        val mealId = savedStateHandle.get<String>("meal_category_id")?: ""

        mealState.value = repository.getMeal(mealId)
    }
}