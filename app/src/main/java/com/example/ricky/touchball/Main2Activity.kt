package com.example.ricky.touchball

import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Created by Ricky on 19/03/2018.
 */
class Main2Activity : AppCompatActivity() {

    private val uiContext: CoroutineContext = UI
    private val bgContext: CoroutineContext = CommonPool

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tareaSegundoPlano()

        var cont = 0
        domotta.setOnClickListener{
            if(cont == 0){
                domotta.setImageResource(R.drawable.ballfaceclck)
                tareaSegundoPlano()
                cont+=1
            }else{
                domotta.setImageResource(R.drawable.ballface)
                tareaSegundoPlano()
                cont-=1
            }
        }
    }

    /**
     * launch coroutine in UI context
     */
    var j : Int = 1
    private fun tareaSegundoPlano() = launch(uiContext) {
        // domotta bajando/subiendo
        j *= -1
        // animamos a domotta, main task in UI
        val objectAnimator = ObjectAnimator.ofFloat(
                domotta,
                "translationY",
                300f*j
        )

        objectAnimator.duration = 500L
        objectAnimator.interpolator
        objectAnimator.start()
    }
}