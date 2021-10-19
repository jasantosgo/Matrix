package com.santosgo.matrix


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class EleccionActivity : AppCompatActivity() {

    private lateinit var lblEleccion : TextView
    private lateinit var eleccionTomada : String
    private lateinit var btnTomar : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eleccion)

        //obtener una referencia a la etiqueta de la actividad
        val lblBienvenido = findViewById<TextView>(R.id.txtSaludo)

        //recogemos el nombre del intent
        val nombre = intent.getStringExtra("NOMBRE")
        val texto = "Bienvenido ${nombre}, ha llegado el momento de tomar una difícil elección."
        //creamos la cadena del saludo
        lblBienvenido.apply {
            text = texto
        }
        lblEleccion = findViewById(R.id.txtEleccion)

        //ejemplo para mostrar el uso de un listener de un objeto.
        val rgPastilla = this.findViewById<RadioGroup>(R.id.rgPastilla)
        rgPastilla.setOnCheckedChangeListener { grupo , idChequeado ->
            comprobarChequeado(idChequeado)
        }

        btnTomar = this.findViewById<Button>(R.id.btnTomar)
        btnTomar.setOnClickListener { esteBoton ->
            println("botón de aceptar pulsado.")
            mostrarFinal(esteBoton)
        }
        btnTomar.isClickable=false
        btnTomar.isActivated=false
        eleccionTomada="roja"
    }

    //funcion para comprobar el boton chequeado
    fun comprobarChequeado(id : Int) {
        println(id)
        when (id) {
            R.id.rbAzul -> println("Azul")
            R.id.rbRoja -> println("Roja")
        }
    }

    //funcion asociada al click de un radioButton.
    fun onRBSeleccionado (view: View) {
        if (view is RadioButton) {
            var txtEleccion = ""
            when (view.id) {
                R.id.rbRoja -> {
                    eleccionTomada = "roja"
                    txtEleccion = "Estás eligiendo adentrarte en MatrixPhone."
                }
                R.id.rbAzul -> {
                    eleccionTomada = "azul"
                    txtEleccion = "Estás eligiendo seguir con tu miserable vida."
                }
            }
            /*lblEleccion.apply {
                text = txtEleccion
            }*/
            lblEleccion.text = txtEleccion
        }
    }

    //Función asociada al botón de Tomar pastilla.
    fun mostrarFinal (view : View) {
        //crear el intent
        val intent = Intent(this, FinalActivity::class.java)

        //añadimos la información necesaria al intent
        intent.putExtra("PASTILLA", eleccionTomada)

        //iniciar la nueva actividad
        startActivity(intent)
    }
}
