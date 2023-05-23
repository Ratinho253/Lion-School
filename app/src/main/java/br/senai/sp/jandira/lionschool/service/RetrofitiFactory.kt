package br.senai.sp.jandira.lionschool.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RetrofitiFactory{

    private val BASE_URL: String
        get() = "https://alive-bull-leotard.cyclic.app/v1/lion-school/Cursos"

    private val retrofitFactory: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getCharacterService () : CharacterService {
        return retrofitFactory.create(CharacterService::class.java)
    }
}