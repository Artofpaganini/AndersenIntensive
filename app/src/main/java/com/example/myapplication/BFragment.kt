package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class BFragment : Fragment(R.layout.fragment_b) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.b_textview).text = requireArguments().getString(SOME_ID)
    }

    companion object {
        const val FRAGMENT_B_TAG = "FRAGMENT_B_TAG"

        private const val SOME_ID = "some id"
        fun newInstance(id: String) = BFragment().also {
            it.arguments = Bundle().apply { putString(SOME_ID, id) }
        }
    }
}