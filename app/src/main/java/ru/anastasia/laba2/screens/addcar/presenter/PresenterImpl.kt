package ru.anastasia.laba2.screens.addcar.presenter



import ru.anastasia.laba2.R
import ru.anastasia.laba2.constant.MAIN
import ru.anastasia.laba2.screens.addcar.view.View
import ru.anastasia.laba2.entity.Car
import ru.anastasia.laba2.model.Model

class PresenterImpl(
    private val view: View?,
    private val model: Model
) : Presenter {

    override fun onSaveButtonClick(b: Car) {
        model.postCar(b)
        MAIN.navController.navigate(R.id.action_addCar_to_carList)
    }
}