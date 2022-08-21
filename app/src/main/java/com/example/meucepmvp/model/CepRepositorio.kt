package com.example.meucepmvp.model

import com.example.meucepmvp.model.entities.Cep
import com.example.meucepmvp.model.interfaces.APIListener
import com.example.meucepmvp.model.remoto.RetrofitClient
import com.example.meucepmvp.model.remoto.services.CepService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.POST

class CepRepositorio {
    private val remoto = RetrofitClient.classService(CepService::class.java)

    fun getCep(cep : String,listener: APIListener<Cep>){
        val call = remoto.buscarCep(cep)
        call.enqueue(object : Callback<Cep>{
            override fun onResponse(call: Call<Cep>, response: Response<Cep>) {
                if(response.code() == 200){
                    println("apkdoandroidInfo: "+response.body())
                    var meuCep = response.body()!!;
                    listener.onSuccess(meuCep)
                }else{
                    listener.onFailures("cod: ${response.code()} ,"+response.message().toString())
                }

            }

            override fun onFailure(call: Call<Cep>, t: Throwable) {
                listener.onFailures(t.message.toString())
            }
        })
    }
}