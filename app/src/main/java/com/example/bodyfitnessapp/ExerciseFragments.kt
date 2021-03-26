package com.example.bodyfitnessapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import pl.droidsonroids.gif.GifImageView


class ExerciseFragments : Fragment() {

    private val exercise : MutableList<Exercise> = mutableListOf(

        Exercise("gifone",8),
        Exercise("giftwo",10),
        Exercise("gifthree",14),
        Exercise("giffour",6),
        Exercise("giffive",20)

    )

    lateinit var btnNext :Button
    lateinit var btnExit : Button
    lateinit var exImage :GifImageView
    lateinit var exViewTxt : TextView
    private lateinit var currentExcs :Exercise
    private var count:Int= 0
    private var exIndex :Int = 0
    private var exSize = Math.min((exercise.size+1)/2,3)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
         val v= inflater.inflate(R.layout.fragment_exercise_fragments, container, false)

        btnNext =  v.findViewById(R.id.btn_next)
        btnExit = v.findViewById(R.id.btnExit)
        exImage = v.findViewById(R.id.gifView)
        exViewTxt = v.findViewById(R.id.txtView)
        randExercise()
         btnNext.setOnClickListener {view:View ->

            exIndex ++
           if (exIndex < exSize ){

               currentExcs = exercise[exIndex]
               setExercise()
           }else{

               view.findNavController().navigate(R.id.action_exerciseFragments_to_wellDoneFragment)
           }

        }


        btnExit.setOnClickListener (

            Navigation.createNavigateOnClickListener(R.id.action_exerciseFragments_to_tryAgainFragment)
                )



        return v
    }

    private fun randExercise() {
        exercise.shuffle()
        exIndex = 0
        setExercise()

    }

    private fun setExercise() {
        currentExcs = exercise[exIndex]
        count = currentExcs.exerciseCount
        exViewTxt.text = String.format(getString( R.string.exCount),count)
        exImage.setImageResource(resources.getIdentifier(currentExcs.exerciseType,"drawable"
                , (activity as AppCompatActivity).packageName))

        (activity as AppCompatActivity).supportActionBar?.title = String.format(getString(R.string.titleBarExNumber),exIndex+1,exSize)

    }


}