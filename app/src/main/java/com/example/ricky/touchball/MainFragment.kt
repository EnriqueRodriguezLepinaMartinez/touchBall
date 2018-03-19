package com.example.ricky.touchball

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import org.jetbrains.anko.support.v4.toast

/**
 * Created by Ricky on 19/03/2018.
 */
/**
 * Fragment que vamos incluir en la Activity principal [Fragment subclass]
 */
class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * Cargamos el layout del fragment
     */
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main, container)
    }
}
