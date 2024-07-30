package com.example.tiptime

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tiptime.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.calculateBtn.setOnClickListener {

            calculateTip()


        }

    }

    private fun calculateTip() {
        val totalCostField = binding.totalCostEditText.text.toString()
        val cost = totalCostField.toIntOrNull()

        if (cost==0 || cost == null){
           displayTip(0.0)
            return
        }

        val tipPercent = when(binding.percentGroup.checkedRadioButtonId){

            R.id.option_twenty_percent -> 0.2
            R.id.option_fifteen_percent -> 0.15
            else -> 0.1
        }

        var tip:Double =(cost*tipPercent)
        if (binding.roundUpSwitch.isChecked){
            tip = kotlin.math.ceil(tip)

        }




        displayTip(tip)





    }
    @SuppressLint("SetTextI18n")
    private fun displayTip(tip : Double){

        binding.displayTipAmountTv.text  = "Total Amount is : $tip"



    }
}