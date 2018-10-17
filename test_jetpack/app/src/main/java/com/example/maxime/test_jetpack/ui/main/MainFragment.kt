package com.example.maxime.test_jetpack.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

import com.example.maxime.test_jetpack.R

class MainFragment : Fragment() {

    private lateinit var mViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.buttonFirst)?.setOnClickListener {
            navigate(view, R.id.action_mainFragment_to_firstFragment)
        }
        view.findViewById<Button>(R.id.buttonSecond)?.setOnClickListener {
            navigate(view, R.id.action_mainFragment_to_secondFragment)
        }
    }

    fun navigate(view: View, fragmentId: Int) {
        Navigation.findNavController(view).navigate(fragmentId)
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}
