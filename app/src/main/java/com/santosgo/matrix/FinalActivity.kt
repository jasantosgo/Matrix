package com.santosgo.matrix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.view.View


class FinalActivity : AppCompatActivity() {

    private lateinit var lblFinal : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        //enlazamos el label
        lblFinal = findViewById(R.id.lblFinal)

        //recogemos la eleccion del intent
        val eleccion = intent.getStringExtra("PASTILLA")
        var texto: String
        if(eleccion == "roja")
            texto = "Vas a adentrarte en el maravilloso mundo de la programación móvil."
        else
            texto = "Busca otras alternativas que den sentido a tu vida."
        lblFinal.apply {
            text = texto
        }
    }

    fun cerrarApp (view:View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.putExtra("EXIT", true)
        startActivity(intent)
    }
}