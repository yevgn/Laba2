package ru.antonov.laba2.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.antonov.laba2.databinding.FragmentEditBookInfoBinding


class EditBookInfo : Fragment() {

    lateinit var binding: FragmentEditBookInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBookInfoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}