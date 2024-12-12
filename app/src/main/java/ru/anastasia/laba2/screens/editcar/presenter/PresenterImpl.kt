package ru.anastasia.laba2.screens.editcar.presenter

import androidx.lifecycle.LifecycleOwner
import ru.anastasia.laba2.R
import ru.anastasia.laba2.constant.MAIN
import ru.anastasia.laba2.datamodel.DataModel
import ru.anastasia.laba2.screens.editcar.view.View
import ru.anastasia.laba2.entity.Car
import ru.anastasia.laba2.model.Model

class PresenterImpl(
    private val view: View?,
    private val model: Model,
    private val dataModel: DataModel
) : Presenter {

    private lateinit var car: Car

    override fun onSaveButtonClick(b: Car) {
        model.putCar(getInfo().name, b)
        MAIN.navController.navigate(R.id.action_editCarInfo_to_carList)
    }

    override fun loadInfo() {
        dataModel.dataForEditCarInfo.observe(view?.getViewLifecycleOwner() as LifecycleOwner) {
            it?.let {
               car = it
            }
        }
    }

    override fun getInfo(): Car = car
}