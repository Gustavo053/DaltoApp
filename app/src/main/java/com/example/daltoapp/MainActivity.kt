package com.example.daltoapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonTeste1 = findViewById<Button>(R.id.buttonTeste1)
        var buttonTeste2 = findViewById<Button>(R.id.buttonTeste2)
        var buttonTeste3 = findViewById<Button>(R.id.buttonTeste3)
        var buttonVerificar = findViewById<Button>(R.id.buttonVerificar)

        var textResposta1 = findViewById<TextView>(R.id.textResposta1)
        var textResposta2 = findViewById<TextView>(R.id.textResposta2)
        var textResposta3 = findViewById<TextView>(R.id.textResposta3)
        var textResultado = findViewById<TextView>(R.id.textResultado)

        buttonTeste1.setOnClickListener {
            var intent = Intent(this, TesteActivity::class.java)
            var bundle = Bundle()

            bundle.putString("OPCAO", "teste1")
            intent.putExtras(bundle)

            startActivityForResult(intent, 1)
        }

        buttonTeste2.setOnClickListener {
            var intent = Intent(this, TesteActivity::class.java)
            var bundle = Bundle()

            bundle.putString("OPCAO", "teste2")
            intent.putExtras(bundle)

            startActivityForResult(intent, 2)
        }

        buttonTeste3.setOnClickListener {
            var intent = Intent(this, TesteActivity::class.java)
            var bundle = Bundle()

            bundle.putString("OPCAO", "teste3")
            intent.putExtras(bundle)

            startActivityForResult(intent, 3)
        }

        buttonVerificar.setOnClickListener {
            if (textResposta1.text.toString() == "Resposta_01" || textResposta2.text.toString() == "Resposta_02" || textResposta3.text.toString() == "Resposta_03") {
                Toast.makeText(this, "Por favor, faça todos os testes", Toast.LENGTH_SHORT).show()
            } else {
                if (textResposta1.text.toString() == "29" && textResposta2.text.toString() == "74" && textResposta3.text.toString() == "8") {
                    textResultado.setText("Visão normal")
                } else {
                    textResultado.setText("Daltonico. Procure um médico")
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var textResposta1 = findViewById<TextView>(R.id.textResposta1)
        var textResposta2 = findViewById<TextView>(R.id.textResposta2)
        var textResposta3 = findViewById<TextView>(R.id.textResposta3)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                1 -> {
                    textResposta1.text = data?.getStringExtra("RESULT").toString()
                }

                2 -> {
                    textResposta2.text = data?.getStringExtra("RESULT").toString()
                }

                3 -> {
                    textResposta3.text = data?.getStringExtra("RESULT").toString()
                }
            }
        }
    }
}