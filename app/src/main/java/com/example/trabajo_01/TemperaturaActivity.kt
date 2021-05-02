package com.example.trabajo_01

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TemperaturaActivity : AppCompatActivity() {

    lateinit var celcius: TextView
    lateinit var fahrenheit: TextView

    lateinit var convertir: Button
    lateinit var limpiar: Button
    lateinit var volver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperatura)

        inicializar()

        volver.setOnClickListener{
            goToActivity(this, MainActivity::class.java)
        }

        convertir.setOnClickListener {
            if(!celcius.text.isEmpty()){
                //convertir(celcius.text.toString())
                fahrenheit.setText(convertir(celcius.text.toString()).toString())
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
        celcius=findViewById(R.id.c_t_celcius)
        fahrenheit=findViewById(R.id.c_t_fahrenheit)
        convertir=findViewById(R.id.c_b_convertir)
        limpiar=findViewById(R.id.c_b_limpiar)
        volver=findViewById(R.id.c_b_volver)
    }

    fun convertir(valor: String): Double{
        var result: Double = valor.toDouble() * 1.8 + 32
        return result
    }

    fun clear(){
        celcius.setText("")
        fahrenheit.setText("")
    }
}