package com.example.meucepmvp.view

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.meucepmvp.R
import com.example.meucepmvp.databinding.ActivityMainBinding
import com.example.meucepmvp.presenter.MainPresenter
import com.example.meucepmvp.view.interfaces.MainView

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainBinding
    private val presenter = MainPresenter(this)
    private var campoCep : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()


        binding.buttonBuscar.setOnClickListener {
            campoCep = binding.editTextCep.text.toString()
            presenter.validarCampo(campoCep)
        }
    }



     fun irParaProximaTela(){
        val bundle = Bundle()
        bundle.putString("cep",campoCep)
        val intent = Intent(applicationContext,ExibirEnderecoActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)

    }

    override fun campoValidado(result: Boolean) {
        if(result){
            irParaProximaTela()
        }
    }

    override fun mensagem(mensagem: String) {
        if(mensagem != ""){
            Toast.makeText(this,mensagem,Toast.LENGTH_SHORT).show()
        }
    }
}