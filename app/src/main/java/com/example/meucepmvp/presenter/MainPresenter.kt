package com.example.meucepmvp.presenter

import com.example.meucepmvp.view.interfaces.MainView

class MainPresenter {
    val view : MainView

    constructor(view: MainView){
        this.view = view
    }

    fun validarCampo(cep : String){
        if(cep != null && cep != "" && cep != " "){
            view.campoValidado(true)
        }else{
            view.mensagem("Preencha o campo corretamente!")
        }

    }

}