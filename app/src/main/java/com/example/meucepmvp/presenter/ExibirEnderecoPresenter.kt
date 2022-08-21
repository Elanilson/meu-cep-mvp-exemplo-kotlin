package com.example.meucepmvp.presenter

import com.example.meucepmvp.model.CepRepositorio
import com.example.meucepmvp.model.entities.Cep
import com.example.meucepmvp.model.interfaces.APIListener
import com.example.meucepmvp.view.interfaces.ExibirEnderrecoView

class ExibirEnderecoPresenter(val view: ExibirEnderrecoView) {
    private  val repositorio = CepRepositorio()

    fun buscarCep(cep: String){
        val listener = object : APIListener<Cep>{
            override fun onSuccess(result: Cep) {
                view.onExebirCEp(result)
            }
            override fun onFailures(mensagem: String) {
                view.mensagem(mensagem)
            }
        }
        repositorio.getCep(cep,listener)

    }
}