package com.example.lesson_1111.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_1111.R
import com.example.lesson_1111.UiState
import com.example.lesson_1111.databinding.FragmentBulbBinding
import com.example.lesson_1111.di.ViewModelFactory
import com.example.lesson_1111.di.appComponent
import javax.inject.Inject


class BulbFragment : Fragment(R.layout.fragment_bulb) {
    private val binding: FragmentBulbBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: BulbViewModel by viewModels {viewModelFactory}

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSwitchOptions()
        setSpinnerOptions()
        setSeekBarOptions()
    }

    private fun setSpinnerOnSelected() {
        val itemSelectedListener: AdapterView.OnItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    val item = parent.getItemAtPosition(position) as String
                    viewModel.setColor(item)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        binding.colorSpinner.onItemSelectedListener = itemSelectedListener
    }

    private fun setSwitchOptions(){
        binding.switchBulb.setOnCheckedChangeListener (null)
        viewModel.bulbState.observe(viewLifecycleOwner){
            if(it is UiState.Success){
                binding.switchBulb.isChecked = it.value
            }
        }
        viewModel.getBulbState()


        binding.switchBulb.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                viewModel.turnOnBulb()
            }else{
                viewModel.turnOffBulb()
            }
        }
    }

    private fun setSeekBarOptions(){
        viewModel.getBrightness()
        viewModel.brightness.observe(viewLifecycleOwner){
            if(it is UiState.Success){
                binding.seekbarBrightness.value = it.value.toFloat()
            }
        }

        binding.seekbarBrightness.addOnChangeListener { _, value, _ ->
            viewModel.setBrightness(value.toInt())
        }
    }

    private fun setSpinnerOptions(){
        viewModel.getCurrentColor()
        viewModel.getColorNames()

        viewModel.currentColorName.observe(viewLifecycleOwner){
            if(it is UiState.Success){
                setColors(it.value)
            }
        }

        setSpinnerOnSelected()
    }

    private fun setColors(colorName: String) {
        viewModel.colorNames.observe(viewLifecycleOwner){
            if(it is UiState.Success){
                binding.colorSpinner.adapter =
                    ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, it.value)

                val index = it.value.indexOf(colorName)
                Log.d("ggg", index.toString())
                if(index != -1){
                    binding.colorSpinner.setSelection(index)
                }
            }
        }
    }
}