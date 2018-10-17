package com.example.maxime.test_jetpack.ui.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

import com.example.maxime.test_jetpack.R


/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button)?.setOnClickListener{
            navigate(view, R.id.action_secondFragment_to_thirdFragment)
        }
    }

    fun navigate(view: View, fragmentId: Int) {
        Navigation.findNavController(view).navigate(fragmentId)
    }
}// Required empty public constructor