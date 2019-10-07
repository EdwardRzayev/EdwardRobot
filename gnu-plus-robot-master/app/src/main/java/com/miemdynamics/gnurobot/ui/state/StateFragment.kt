package com.miemdynamics.gnurobot.ui.state

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.miemdynamics.gnurobot.R

class StateFragment : Fragment() {

    companion object {
        fun newInstance() = StateFragment()
    }

    private lateinit var viewModel: StateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.state_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StateViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
