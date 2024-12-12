package ru.anastasia.laba2.screens.addcar.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ru.anastasia.laba2.entity.Car
import ru.anastasia.laba2.screens.addcar.presenter.Presenter
import ru.anastasia.laba2.screens.addcar.presenter.PresenterImpl


import ru.anastasia.laba2.databinding.FragmentAddCarBinding
import ru.anastasia.laba2.model.ModelImpl

class AddCar : Fragment(), ru.anastasia.laba2.screens.addcar.view.View {

    private lateinit var binding : FragmentAddCarBinding
    private var presenter: Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddCarBinding.inflate(layoutInflater, container, false)
        presenter = PresenterImpl(this, ModelImpl())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.saveDataButton.setOnClickListener {
            val name = binding.carNameEt.text.toString()
            val engineVolume = binding.carEngineVolumeEt.text.toString()
            val speed  = binding.carSpeedEt.text.toString()
            val year  = binding.carYearEt.text.toString()

            if(name.isEmpty() || engineVolume.isEmpty() || speed.isEmpty()
                || year.isEmpty()) {
                Toast.makeText(
                    context, "Остались незаполненные поля", Toast.LENGTH_SHORT
                ).show()
            } else{
                presenter?.onSaveButtonClick(Car(name, engineVolume.toFloat(), speed.toFloat(), year.toInt()))
            }
        }
    }

}