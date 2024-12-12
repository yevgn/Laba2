package ru.anastasia.laba2.screens.carinfo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import ru.anastasia.laba2.entity.Car
import ru.anastasia.laba2.screens.carinfo.presenter.Presenter
import ru.anastasia.laba2.screens.carinfo.presenter.PresenterImpl

import ru.anastasia.laba2.databinding.FragmentCarInfoBinding
import ru.anastasia.laba2.datamodel.DataModel

class CarInfo : Fragment(), ru.anastasia.laba2.screens.carinfo.view.View {

    private lateinit var binding: FragmentCarInfoBinding
    private val dataModel : DataModel by activityViewModels()
    private var presenter: Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarInfoBinding.inflate(layoutInflater, container, false)
        presenter = PresenterImpl(this, dataModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter?.loadInfo()

        binding.editDataButton.setOnClickListener {
            presenter?.onEditButtonClick()
        }
    }

    override fun showInfo(b: Car) {
        binding.carNameTv.text = b.name
        binding.carEngineVolumeTv.text = b.engineVolume.toString()
        binding.carSpeedTv.text = b.speed.toString()
        binding.carYearTv.text = b.year.toString()
    }
}