package com.example.myapplication

import androidx.fragment.app.Fragment

class AFragment : Fragment(R.layout.fragment_a) {

    companion object {
        const val FRAGMENT_A_TAG = "FRAGMENT_A_TAG"
        fun newInstance() = AFragment()
    }
}