package com.example.salarioliquido_tp7

import androidx.appcompat.app.AppCompatActivity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.io.FileOutputStream
import java.text.SimpleDateFormat

class MainActivity extends AppCompatActivity {

    val ARQUIVO = "salario.txt"

    var txtSalarioBruto: EditText? =
        null, private  var txtDependentes:EditText? = null, private  var txtPensao:EditText? = null, private  var txtSaude:EditText? = null, private  var txtOutrosDescontos:EditText? = null
    var lblDescontos: TextView? =
        null, private  var lblPorcentagemDescontos:TextView? = null, private  var lblSalarioLiquido:TextView? = null

    var valorINSS =
        0.0, private  var valorIRRF:kotlin.Double = 0.0, private  var deducaoDependentes:kotlin.Double = 0.0
    var descontoINSS: String? =
        null, private  var descontoIRRF:kotlin.String? = null, private  var salarioLiquido:kotlin.String? = null, private  var date:kotlin.String? = null


    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnCalcularOnClick(v: View?) {
        txtSalarioBruto = findViewById<EditText>(R.id.txtSalarioBruto)
        txtDependentes = findViewById<EditText>(R.id.txtDependentes)
        txtPensao = findViewById<EditText>(R.id.txtPensao)
        txtSaude = findViewById<EditText>(R.id.txtSaude)
        txtOutrosDescontos = findViewById<EditText>(R.id.txtOutrosDescontos)
        lblSalarioLiquido = findViewById<TextView>(R.id.lblSalarioLiquido)
        lblDescontos = findViewById<TextView>(R.id.lblDescontos)
        lblPorcentagemDescontos = findViewById<TextView>(R.id.lblPorcentagemDescontos)
        val salarioBruto: Double = txtSalarioBruto!!.text.toString().toInt().toDouble()

        //Calculo Deoendentes
        val deducaoDependentes: Double = txtDependentes.getText().toString().toFloat() * 189.59

        //Calcular INSS
        val descontoINSS: Double = calculoINSS(salarioBruto)
        val salarioBase = salarioBruto - descontoINSS - deducaoDependentes

        //Calcular IRRF
        val descontoIRRF: Double = calculoIRRF(salarioBase)
        val salarioLiquido = salarioBruto - descontoINSS - descontoIRRF


        //Preenche o campo com o Salario Liquido
        lblSalarioLiquido.setText(salarioLiquido.toInt())
        val date: String = dateNow()

        //TODO: arrumar arquivo para texto
        gravarArquivoTexto()
    }

    open fun calculoINSS(salario: Double): Double {
        //Primeira Faixa
        if (salario < 1.045) {
            descontoINSS = "7.5%"
            valorINSS = 78.38
        } else if (salario > 1045.01 && salario < 2089.60) {
            descontoINSS = "9%"
            valorINSS = 172.39
        } else if (salario > 2089.61 && salario < 3134.40) {
            descontoINSS = "12%"
            valorINSS = 297.77
        } else if (salario > 3134.41 && salario < 6101.06) {
            descontoINSS = "14%"
            valorINSS = 713.08
        } else if (salario > 6101.06) {
            descontoINSS = "TETO"
            valorINSS = 713.08
        }
        return valorINSS
    }

    open fun calculoIRRF(salarioBase: Double): Double {
        //Primeira Faixa
        if (salarioBase < 1903.98) {
            descontoIRRF = "0%"
            valorIRRF = 0.toDouble()
        } else if (salarioBase > 1903.99 && salarioBase < 2826.65) {
            descontoIRRF = "7.5%"
            valorIRRF = salarioBase * 7.5 / 100 - 142.80
        } else if (salarioBase > 2826.66 && salarioBase < 3751.05) {
            descontoIRRF = "15%"
            valorIRRF = salarioBase * 15 / 100 - 354.80
        } else if (salarioBase > 3751.06 && salarioBase < 4664.68) {
            descontoIRRF = "22,5%"
            valorIRRF = salarioBase * 22.5 / 100 - 636.13
        } else if (salarioBase > 4664.69) {
            descontoIRRF = "27,5%"
            valorIRRF = salarioBase * 27.5 / 100 - 869.36
        }
        return valorIRRF
    }

    fun dateNow(): String? {
        val date = System.currentTimeMillis()
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy  hh:mm:ss")
        return simpleDateFormat.format(date)
    }

    fun gravarArquivoTexto() {
        try {
            val out: FileOutputStream = openFileOutput(ARQUIVO, Context.MODE_APPEND)
            val texto: String =
                date + txtDependentes + txtPensao + txtOutrosDescontos + salarioLiquido + descontoINSS + descontoIRRF
            out.write(texto.toByteArray())
            out.close()
        } catch (e: Exception) {
            Log.e("ERRO", e.message!!)
        }
    }
