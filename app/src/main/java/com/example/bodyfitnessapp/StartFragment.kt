package com.example.bodyfitnessapp

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController


class StartFragment : Fragment() {

    lateinit var imgVieOfrag :Image
    lateinit var go_btn :Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val v = inflater.inflate(R.layout.fragment_start, container, false)
       go_btn = v.findViewById(R.id.btnStartFrag)
        go_btn.setOnClickListener (

            Navigation.createNavigateOnClickListener(R.id.action_start2_to_exerciseFragments)
                )


        return v
    }
}

