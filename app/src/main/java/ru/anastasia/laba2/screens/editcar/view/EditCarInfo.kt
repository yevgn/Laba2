package ru.anastasia.laba2.screens.editcar.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import ru.anastasia.laba2.entity.Car

import ru.anastasia.laba2.databinding.FragmentEditCarInfoBinding
import ru.anastasia.laba2.datamodel.DataModel
import ru.anastasia.laba2.screens.editcar.presenter.Presenter
import ru.anastasia.laba2.screens.editcar.presenter.PresenterImpl
import ru.anastasia.laba2.model.ModelImpl


class EditCarInfo : Fragment(), ru.anastasia.laba2.screens.editcar.view.View {

    private lateinit var binding: FragmentEditCarInfoBinding
    private val dataModel : DataModel by activityViewModels()
    private var presenter: Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditCarInfoBinding.inflate(layoutInflater, container, false)
        presenter = PresenterImpl(this, ModelImpl(), dataModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter?.loadInfo()

        binding.saveDataButton.setOnClickListener {
            val newName = binding.carNameEt.text.toString()
            val newEngineVolume = binding.carEngineVolumeEt.text.toString()
            val newSpeed  = binding.carSpeedEt.text.toString()
            val newYear   = binding.carYearEt.text.toString()

            if(newName.isEmpty() || newEngineVolume.isEmpty() || newSpeed.isEmpty()
                || newYear.isEmpty()) {
                Toast.makeText(
                    context, "Остались незаполненные поля", Toast.LENGTH_SHORT
                ).show()
            } else{
                Toast.makeText(context, "Данные были редактированы", Toast.LENGTH_SHORT).show()
                presenter?.onSaveButtonClick(Car(newName,newEngineVolume.toFloat(), newSpeed.toFloat(), newYear.toInt() ))
            }
        }
    }

}