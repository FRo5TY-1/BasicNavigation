package com.example.basicnavigation.Fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.basicnavigation.R

class FragmentNotifications : Fragment(R.layout.fragment_notifications) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var channelName = FragmentSubscriptionsArgs.fromBundle(requireArguments()).channelName

        view.findViewById<TextView>(R.id.textViewnotifications).text =
            "You will now receive notifications from $channelName"

    }
}