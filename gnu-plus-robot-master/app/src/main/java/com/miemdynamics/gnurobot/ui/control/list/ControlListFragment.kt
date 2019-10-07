package com.miemdynamics.gnurobot.ui.control.list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.miemdynamics.gnurobot.R
import com.miemdynamics.gnurobot.data.network.ConnectivityInterceptorImpl
import com.miemdynamics.gnurobot.data.network.FakeServoApiService
import com.miemdynamics.gnurobot.data.network.ServoNetworkDataSourceImpl
import com.miemdynamics.gnurobot.data.request.FakeServoGet
import kotlinx.android.synthetic.main.control_list_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ControlListFragment : Fragment() {

    companion object {
        fun newInstance() = ControlListFragment()
    }

    private lateinit var viewModel: ControlListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.control_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ControlListViewModel::class.java)
        // TODO: Use the ViewModel
        val request = FakeServoGet(id = 3);
        val apiService = FakeServoApiService(ConnectivityInterceptorImpl(this.context!!))
        val servoNetworkDataSource = ServoNetworkDataSourceImpl(apiService)

        servoNetworkDataSource.downloadedServo.observe(this, Observer {
            textView.text = it.toString()
        })

        GlobalScope.launch(Dispatchers.Main) {
            servoNetworkDataSource.fetchServo(1)
        }
    }
}
