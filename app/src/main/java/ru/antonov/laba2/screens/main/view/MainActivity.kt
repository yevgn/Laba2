package ru.antonov.laba2.screens.main.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.antonov.laba2.R
import ru.antonov.laba2.constant.MAIN
import ru.antonov.laba2.databinding.ActivityMainBinding
import ru.antonov.laba2.model.ModelImpl
import ru.antonov.laba2.screens.main.presenter.Presenter
import ru.antonov.laba2.screens.main.presenter.PresenterImpl

class MainActivity : AppCompatActivity(), View {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    private var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = PresenterImpl(this, ModelImpl())
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        MAIN = this

        binding.bottomNavigationView.setOnItemSelectedListener {
            presenter?.onBottomNavigationViewClick(it)
            true
        }

        binding.backButton.setOnClickListener {
            presenter?.onBackButtonClick()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}