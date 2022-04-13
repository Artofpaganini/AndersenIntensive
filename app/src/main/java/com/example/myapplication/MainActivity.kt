package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * ШАГ4
 * Имплементим  интефейс в нашу активити
 */
class MainActivity : AppCompatActivity(), FragmentNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().run {
            val fragment = AFragment.newInstance()

            replace(R.id.activity_frame_layout, fragment, AFragment.FRAGMENT_A_TAG)
            addToBackStack(AFragment.FRAGMENT_A_TAG)

            commit()
        }

    }

    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    /**
     * ШАГ 5
     * Переопределяем наш  метод инрефейса и пишем его реализацию в активити
     */
    override fun fromAtoB() {
        supportFragmentManager.beginTransaction().run {
            val fragment = BFragment.newInstance("some ID")

            replace(R.id.activity_frame_layout, fragment, BFragment.FRAGMENT_B_TAG)

            addToBackStack(BFragment.FRAGMENT_B_TAG)
            commit()
        }
    }
}