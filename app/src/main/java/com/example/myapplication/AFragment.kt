package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class AFragment : Fragment(R.layout.fragment_a) {
    /**
     * Надо создать поле для работы с нашим интерфейсом
     *
     */
    private var navigator: FragmentNavigator? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /**
         *    3ШАГ
         *     После создания  интерфейса, мы должны определить  что  контеткс является тем, который нам необходим
         */
        if (context is FragmentNavigator) navigator = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn).setOnClickListener {
            navigator?.fromAtoB()
        }
    }

    companion object {
        const val FRAGMENT_A_TAG = "FRAGMENT_A_TAG"
        fun newInstance() = AFragment()
    }
}


/**
 *     1ШАГ
 *     Т.К. у нас 2 фрагмента  равноценны   и не являются  вложенными, мы не можем использовать
 *     childFragmentManager, а так же  parentFragmentManager(напомню, это плохая практика)
 *     Но мы можем исопльзовать  так называй  коллбек, загуглите что  это такое и как с этим работать
 *     По сути  это  интерфейс который дергается тут , а  всю  логику выполнит в каком то другом месте, в нашему случае
 *      в активити
 *      Название я  задал  произвольное , не забываем что название должно передавать смысл
 */

interface FragmentNavigator {
    fun fromAtoB()
}