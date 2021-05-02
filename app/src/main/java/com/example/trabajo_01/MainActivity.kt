package com.example.trabajo_01

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var palindromos: Button
    lateinit var conversor: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarElementos()

        palindromos.setOnClickListener{
            goToActivity(this, PalindromoActivity::class.java)
        }

        conversor.setOnClickListener{
            goToActivity(this, TemperaturaActivity::class.java)
        }
    }

    fun inicializarElementos(){
        palindromos=findViewById(R.id.i_b_palindromos)
        conversor=findViewById(R.id.i_b_conversor)
    }

    fun <T>goToActivity(context: Context, nuevaVista: Class<T>){
        val intento: Intent = Intent(context, nuevaVista)
        startActivity(intento)
    }


}