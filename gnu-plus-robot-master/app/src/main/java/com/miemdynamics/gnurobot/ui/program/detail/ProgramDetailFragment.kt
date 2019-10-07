package com.miemdynamics.gnurobot.ui.program.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.miemdynamics.gnurobot.R

class ProgramDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ProgramDetailFragment()
    }

    private lateinit var viewModel: ProgramDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.program_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProgramDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
