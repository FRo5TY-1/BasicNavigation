package com.example.basicnavigation.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.BasicNavigation.Fragments.HomeFragmentDirections
import com.example.basicnavigation.R

class FragmentSubscriptions : Fragment(R.layout.fragment_subscriptions) {

    private lateinit var buttonSend: Button
    private lateinit var channelSub: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = Navigation.findNavController(view)
        buttonSend = view.findViewById(R.id.buttonSend)

        var channelName = FragmentSubscriptionsArgs.fromBundle(requireArguments()).channelName

        if (channelName.isNotEmpty())
            channelSub = "You have subscribed to $channelName, would you also like to receive notifications from $channelName?"

        view.findViewById<TextView>(R.id.textViewChannelSub).text = channelSub

        buttonSend.setOnClickListener {
            if (channelSub.isEmpty())
                return@setOnClickListener

            val action = FragmentSubscriptionsDirections.actionFragmentSubscriptionsToFragmentNotifications(channelName)
            controller.navigate(action)
        }
    }
}