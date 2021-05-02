package com.example.trabajo_01

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class PalindromoActivity : AppCompatActivity() {

    lateinit var verificar: Button
    lateinit var limpiar: Button
    lateinit var volver: Button
    lateinit var palabra: TextView

    lateinit var palindromoTrue: TextView
    lateinit var palindromoFalse: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palindromo)
        inicializar()

        volver.setOnClickListener{
            goToActivity(this, MainActivity::class.java)
        }

        verificar.setOnClickListener {
            if(!palabra.text.isEmpty()){
                if(esPalindromo()){
                    palindromoTrue.visibility = View.VISIBLE
                    palindromoFalse.visibility = View.GONE
                } else {
                    palindromoFalse.visibility = View.VISIBLE
                    palindromoTrue.visibility = View.GONE
                }
            } else {
                Toast.makeText(this, "Debe ingresar una palabra para verificar", Toast.LENGTH_LONG).show()
            }
        }

        limpiar.setOnClickListener {
            clear()
        }
    }

    fun <T>goToActivity(context: Context, nuevaVista: Class<T>){
        val intento: Intent = Intent(context, nuevaVista)
        startActivity(intento)
    }

    fun inicializar(){
        volver=findViewById(R.id.p_b_volver)
        verificar=findViewById(R.id.p_b_verificar)
        limpiar=findViewById(R.id.p_b_limpiar)
        palabra=findViewById(R.id.p_t_palabra)

        palindromoTrue=findViewById(R.id.p_t_palindromo)
        palindromoFalse=findViewById(R.id.p_t_nopali)
    }

    fun clear(){
        palabra.setText("")
        palindromoTrue.visibility = View.GONE
        palindromoFalse.visibility = View.GONE
    }


    fun esPalindromo():Boolean {
        var letrasArray:CharArray = palabra.text.toString().toCharArray();
        letrasArray.reverse()
        var palabraReverse:String = ""
        letrasArray.forEach { item -> palabraReverse += item }
        return palabra.text.toString().equals(palabraReverse)
    }
}