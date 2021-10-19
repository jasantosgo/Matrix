package com.santosgo.matrix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (intent.getBooleanExtra("EXIT", false)) {
            finish()
        }
    }

    fun mostrarEleccion(view : View) {
        //crear el intent
        val intent = Intent(this@MainActivity, EleccionActivity::class.java)
        //tomar el valor del cuadro de texto.
        val txtNombre = this.findViewById<EditText>(R.id.txtNombre)
        //añadimos la información necesaria al intent
        intent.putExtra("NOMBRE", txtNombre.text.toString())

        //iniciar la nueva actividad
        startActivity(intent)

    }
}