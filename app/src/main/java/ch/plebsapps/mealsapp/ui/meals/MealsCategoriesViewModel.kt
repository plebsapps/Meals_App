package ch.plebsapps.mealsapp.ui.meals

import androidx.lifecycle.ViewModel
import ch.plebsapps.mealsapp.model.MealsRepository

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository() ) : ViewModel() {
}