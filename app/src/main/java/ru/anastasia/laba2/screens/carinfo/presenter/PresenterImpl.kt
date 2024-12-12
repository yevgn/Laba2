package ru.anastasia.laba2.screens.carinfo.presenter

import androidx.lifecycle.LifecycleOwner
import ru.anastasia.laba2.R
import ru.anastasia.laba2.constant.MAIN
import ru.anastasia.laba2.screens.carinfo.view.View
import ru.anastasia.laba2.datamodel.DataModel
import ru.anastasia.laba2.entity.Car

class PresenterImpl(
    private val view: View?,
    private val dataModel: DataModel
) : Presenter {

    private lateinit var car : Car

    override fun loadInfo() {
        dataModel.dataForCarInfo.observe(view?.getViewLifecycleOwner() as LifecycleOwner) {
            it?.let {
                car = it
                view.showInfo(it)
            }
        }
    }

    override fun onEditButtonClick() {
        dataModel.dataForEditCarInfo.value = getInfo().copy()
        MAIN.navController.navigate(R.id.action_carInfo_to_editCarInfo)
    }

    override fun getInfo(): Car = car
}