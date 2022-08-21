package com.example.meucepmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.meucepmvp.R
import com.example.meucepmvp.databinding.ActivityExibirEnderecoBinding
import com.example.meucepmvp.model.entities.Cep
import com.example.meucepmvp.presenter.ExibirEnderecoPresenter
import com.example.meucepmvp.view.interfaces.ExibirEnderrecoView

class ExibirEnderecoActivity : AppCompatActivity(),ExibirEnderrecoView {
    private lateinit var binding: ActivityExibirEnderecoBinding
    private val presenter = ExibirEnderecoPresenter(this)
    private var cep : String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExibirEnderecoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onResume() {
        super.onResume()
        val bundle = intent.extras
        if(bundle != null){
            cep = bundle.getString("cep")!!
            presenter.buscarCep(cep)
        }
    }

    override fun onExebirCEp(cep: Cep) {
        binding.textViewCep.setText(cep.cep)
        binding.textViewBairro.setText(cep.bairro)
        binding.textViewLogradouro.setText(cep.logradouro)
        binding.textViewComplemento.setText(cep.complemento)
        binding.textViewLocalidade.setText(cep.localidade)
        binding.textView2Uf.setText(cep.uf)
        binding.textViewDDD.setText(cep.ddd)
    }

    override fun mensagem(mensagem: String) {
        Toast.makeText(applicationContext,mensagem,Toast.LENGTH_SHORT).show()
    }
}