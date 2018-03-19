package com.example.ricky.touchball

import android.content.Intent
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import org.jetbrains.anko.image

/**
 * Clase creada para trabajar con Kotlin
 * utiliza el layout activity_main que contiene al fragment referenciado con la clase MainFragment
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start.setOnClickListener {
            val datos = Intent(this,Main2Activity::class.java)
            datos.putExtra("key1","valor1")
            startActivity(datos)

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
}
