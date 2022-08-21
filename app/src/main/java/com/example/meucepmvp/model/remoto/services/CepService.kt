package com.example.meucepmvp.model.remoto.services

import com.example.meucepmvp.model.entities.Cep
import retrofit2.Call
import retrofit2.http.*

interface CepService {
    @GET("{cep}/json/")
   fun buscarCep(@Path(value = "cep",encoded = true) cep : String ) : Call<Cep>
}