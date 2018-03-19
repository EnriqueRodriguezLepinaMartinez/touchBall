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

        // Listener del boton animacion que ejecuta una tarea de animacion en segundo plano
        animacion.setOnClickListener {
            tareaSegundoPlano()
        }

        var cont = 0
        domotta.setOnClickListener{
            if(cont == 0){
                domotta.setImageResource(R.drawable.ballfaceclck)
                cont+=1
            }else{
                domotta.setImageResource(R.drawable.ballface)
                cont-=1
            }
        }
    }

    /**
     * launch coroutine in UI context
     */

    var j : Int = 1
    var job2 : Job? = null

    private fun tareaSegundoPlano() = launch(uiContext) {
        // tarea child en el contexto de este hilo/thread
        // contador de 30 hacia 1
        val task2 = async(bgContext) {
            for (i in 30 downTo 1) { // countdown from 10 to 1
                //texto2.text = "Countdown $i ..." // update text
                Log.d("Task2", "Contandor: ${i}")
                delay(200) // wait half a second
            }
        }
        job2 = task2
        // non ui thread (child task)
        // lanzamos la tarea
        val result = task2.start()
        // tambien podemos job2?.start()

        // domotta bajando/subiendo
        // esta tarea es la tarea principal
        j *= -1
        // animamos a domotta, main task in UI
        val objectAnimator = ObjectAnimator.ofFloat(
                domotta,
                "translationY",
                300f*j)
        objectAnimator.duration = 3000L
        objectAnimator.interpolator
        objectAnimator.start()
    }
}