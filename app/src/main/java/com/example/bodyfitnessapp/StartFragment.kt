package com.example.bodyfitnessapp

import android.media.Image
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI


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

        setHasOptionsMenu(true)


        return v
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.about_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,requireView().findNavController()) ||
        super.onOptionsItemSelected(item)
    }
}

