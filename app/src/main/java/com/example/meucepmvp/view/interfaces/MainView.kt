package com.example.meucepmvp.view.interfaces

interface MainView {
    fun campoValidado(result: Boolean = false)
    fun mensagem(mensagem: String ="")
}