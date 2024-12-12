package ru.anastasia.laba2.screens.carlist.presenter

import ru.anastasia.laba2.R
import ru.anastasia.laba2.constant.MAIN
import ru.anastasia.laba2.screens.carlist.view.View
import ru.anastasia.laba2.datamodel.DataModel
import ru.anastasia.laba2.entity.Car
import ru.anastasia.laba2.model.Model

class PresenterImpl(
    private val view: View?,
    private val model: Model,
    private val dataModel: DataModel): Presenter {

    override fun onDeleteButtonClick(b: Car) {
        model.deleteCar(b)
        loadDataFromModel()
    }

    override fun onAddButtonClick() {
        MAIN.navController.navigate(R.id.action_carList_to_addCar)
    }

    override fun onItemClick(b: Car) {
        dataModel.dataForCarInfo.value = b
        MAIN.navController.navigate(R.id.action_carList_to_carInfo)
    }

    override fun loadDataFromModel() {
        val dataFromModel = model.getAllCars()
        view?.showCars(dataFromModel)
    }
}