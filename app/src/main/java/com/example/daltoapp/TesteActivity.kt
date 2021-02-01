package com.example.daltoapp

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class TesteActivity : AppCompatActivity() {
    var code = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)

        var imageOpcao = findViewById<ImageView>(R.id.imageOpcao)
        var editTextResposta = findViewById<EditText>(R.id.editTextResposta)

        var buttonOk = findViewById<Button>(R.id.buttonOk)
        var buttonCancelar = findViewById<Button>(R.id.buttonCancelar)

        var params:Bundle? = intent.extras
        var opcao = params?.getString("OPCAO")

        if (opcao.toString() == "teste1") {
            imageOpcao.setImageDrawable(resources.getDrawable(R.drawable.teste1))
        } else if (opcao.toString() == "teste2") {
            imageOpcao.setImageDrawable(resources.getDrawable(R.drawable.teste2))
        } else if (opcao.toString() == "teste3") {
            imageOpcao.setImageDrawable(resources.getDrawable(R.drawable.teste3))
        }

        var intent = Intent(this, MainActivity::class.java)
        var bundle = Bundle()

        buttonOk.setOnClickListener {
            bundle.putString("RESULT", editTextResposta.text.toString())
            intent.putExtras(bundle)

            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        buttonCancelar.setOnClickListener {
            finish()
        }
    }
}