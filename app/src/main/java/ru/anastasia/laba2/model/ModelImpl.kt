package ru.anastasia.laba2.model

import ru.anastasia.laba2.constant.carList
import ru.anastasia.laba2.entity.Car
import java.util.function.Predicate

class ModelImpl : Model {

    override fun getCar(name: String): Car? {
       return filterData { it.name == name}
    }

    override fun getCar(id: Int): Car?{
        return filterData { it.id == id}
    }

    override fun getAllCars(): MutableList<Car> {
        return carList.toMutableList()
    }

    override fun postCar(b: Car) {
        carList.add(b)
    }

    override fun putCar(id: Int, b: Car) {
        val car = filterData { it.id == id }
        if(car!= null){
            car.name = b.name
            car.engineVolume = b.engineVolume
            car.speed = b.speed
            car.year = b.year
        }
    }

    override fun putCar(name: String, b: Car) {
        val car = filterData { it.name == name }
        if(car!= null){
            car.name = b.name
            car.engineVolume = b.engineVolume
            car.speed = b.speed
            car.year = b.year
        }
    }

    override fun deleteCar(id: Int) {
        val car = filterData { it.id == id}
        if(car!=null){
            carList.remove(car)
        }
    }

    override fun deleteCar(name: String) {
        val car = filterData { it.name == name}
        if(car!=null){
            carList.remove(car)
        }
    }

    override fun deleteCar(b: Car) {
        carList.remove(b)
    }

    private fun filterData(filter: Predicate<Car>): Car? {
        return carList.stream().filter(filter).findAny().orElse(null)
    }
}