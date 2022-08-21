package com.example.meucepmvp.model.interfaces

interface APIListener<T> {
    fun onSuccess(result : T)
    fun onFailures(mensagem: String)
}