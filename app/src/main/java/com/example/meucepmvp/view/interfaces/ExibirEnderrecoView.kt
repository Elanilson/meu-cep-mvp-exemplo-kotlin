package com.example.meucepmvp.view.interfaces

import com.example.meucepmvp.model.entities.Cep

interface ExibirEnderrecoView {
    fun onExebirCEp(cep: Cep)
    fun mensagem(mensagem: String)
}