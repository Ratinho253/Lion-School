package br.senai.sp.jandira.lionschool.service

import android.telecom.Call
import br.senai.sp.jandira.lionschool.model.CoursesList
import br.senai.sp.jandira.lionschool.model.StudentsList
import retrofit2.http.GET
import retrofit2.http.Query

interface StudentsServices {

    //https://alive-bull-leotard.cyclic.app/v1/lion-school/

    @GET("alunos")
    fun getCoursesStudents(@Query("cursos") studentsCourses : String ) : retrofit2.Call<StudentsList>
}