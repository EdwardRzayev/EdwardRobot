package com.miemdynamics.gnurobot.ui.program.list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.miemdynamics.gnurobot.R

class ProgramListFragment : Fragment() {

    companion object {
        fun newInstance() = ProgramListFragment()
    }

    private lateinit var viewModel: ProgramListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.program_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProgramListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
