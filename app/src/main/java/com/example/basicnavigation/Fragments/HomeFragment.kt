package com.example.BasicNavigation.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.basicnavigation.R

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var editTextChannel: EditText
    private lateinit var buttonSend: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = Navigation.findNavController(view)

        editTextChannel = view.findViewById(R.id.editTextChannel)
        buttonSend = view.findViewById(R.id.buttonSend)

        buttonSend.setOnClickListener {

            var channelName = editTextChannel.text.toString()
            if (channelName.isEmpty())
                return@setOnClickListener

            val action = HomeFragmentDirections.actionHomeFragmentToFragmentSubscriptions(channelName)

            controller.navigate(action)
        }
    }
}
