package com.ritikcoder.project30ofandroiddev_colormyview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ritikcoder.project30ofandroiddev_colormyview.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding
    var box1: Boolean= false
    var box2: Boolean= false
    var box3: Boolean= false
    var box4: Boolean= false
    var box5: Boolean= false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //this is the method what i have created down bellow.
        setListeners()

    }

    //Here is my method.
    private fun setListeners() {
        binding.apply {
            val clickableView: List<View> = listOf(
                boxOneText,
                boxTwoText,
                boxThreeText,
                boxFourText,
                boxFiveText,
                constraintLayout,
                redButton,
                yellowButton,
                greenbutton
            )

            for (item in clickableView) {
                item.setOnClickListener { makeColored(it) }
            }
        }
    }

    private fun makeColored(view: View?) {

        if (view != null) {
//            when (view.id) {
//                R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
//                R.id.box_two_text -> view.setBackgroundResource(R.color.blue)
//                R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
//                R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
//                R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_blue_dark)
//                R.id.redButton -> binding.boxThreeText.setBackgroundResource(R.color.red)
//                R.id.yellowButton -> binding.boxFourText.setBackgroundResource(R.color.yellow)
//                R.id.greenbutton -> binding.boxFiveText.setBackgroundResource(R.color.green)
//
//                else -> view.setBackgroundColor(Color.LTGRAY)
//
//            }
            if (view.id == R.id.box_one_text){
                view.setBackgroundColor(Color.DKGRAY)
                box1= true
                gameCompleteCondition()
            }
            if (view.id == R.id.box_two_text){
                view.setBackgroundResource(R.color.blue)
                box2= true
                gameCompleteCondition()
            }
            if (view.id == R.id.box_three_text){
                view.setBackgroundResource(android.R.color.holo_green_light)
                box3= false
                gameCompleteCondition()
            }
            if (view.id == R.id.box_four_text){
                view.setBackgroundResource(android.R.color.holo_green_dark)
                box4= true
                gameCompleteCondition()
            }
            if (view.id == R.id.box_five_text){
                view.setBackgroundResource(android.R.color.holo_blue_dark)
                box5= true
                gameCompleteCondition()
            }
            if (view.id == R.id.redButton){
                binding.boxThreeText.setBackgroundResource(R.color.red)
                box3= true
                gameCompleteCondition()
            }
            if (view.id == R.id.yellowButton){
                binding.boxFourText.setBackgroundResource(R.color.yellow)
                box4= false
                gameCompleteCondition()
            }
            if (view.id == R.id.greenbutton){
                binding.boxFiveText.setBackgroundResource(R.color.green)
                box5= false
                gameCompleteCondition()
            }
        }
    }

    //Game winning conditions.
    private fun gameCompleteCondition(){
        if (box1 && box2 && box3 && box4 && box5){
            Toast.makeText(this, "Game is Completed", Toast.LENGTH_SHORT).show()
            val builder= AlertDialog.Builder(this)
            builder.setTitle("RitikCoder's Game")
            builder.setMessage("You have completed this Pattern")
                .setPositiveButton("Play Again"){ dialog, which ->
                    binding.boxOneText.setBackgroundResource(R.color.black)
                    binding.boxTwoText.setBackgroundResource(R.color.black)
                    binding.boxThreeText.setBackgroundResource(R.color.black)
                    binding.boxFourText.setBackgroundResource(R.color.black)
                    binding.boxFiveText.setBackgroundResource(R.color.black)
                    box1= false
                    box2= false
                    box3= false
                    box4= false
                    box5= false
                }
                .setNegativeButton("Finish"){ dialog, which ->
                    finish()
                }
            val alertDialog: AlertDialog= builder.create()
            alertDialog.show()
        }
    }

}