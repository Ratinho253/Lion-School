package br.senai.sp.jandira.lionschool.service

import android.telecom.Call
import br.senai.sp.jandira.lionschool.model.CoursesList
import retrofit2.http.GET

interface CoursesServices {

    //https://alive-bull-leotard.cyclic.app/v1/lion-school/

    @GET("cursos")
    fun getCourses(): retrofit2.Call<CoursesList>
}
