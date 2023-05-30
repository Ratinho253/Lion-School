package br.senai.sp.jandira.lionschool.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetofitiFactory {

    private val BASE_URL: String
        get() = "https://alive-bull-leotard.cyclic.app/v1/lion-school/"

    private val retrofitFactory: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getCharacterService () : CoursesServices {
        return retrofitFactory.create(CoursesServices::class.java)
    }

    fun getStudentsService(): StudentsServices {
        return retrofitFactory.create(StudentsServices::class.java)
    }
}