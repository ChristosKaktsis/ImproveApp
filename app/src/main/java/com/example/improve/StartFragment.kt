package com.example.improve

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController


class StartFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button1 = view.findViewById<Button>(R.id.e1rm_button)
        val button2 = view.findViewById<Button>(R.id.ww_button)
        button1.setOnClickListener { goTo(R.id.action_startFragment_to_calculateE1RMFragment) }
        button2.setOnClickListener { goTo(R.id.action_startFragment_to_calculateWWFragment) }
    }

    private fun goTo(action: Int) {
        findNavController().navigate(action);
    }

}