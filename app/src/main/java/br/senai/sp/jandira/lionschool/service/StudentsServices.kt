package br.senai.sp.jandira.lionschool.service

import br.senai.sp.jandira.lionschool.model.Student
import br.senai.sp.jandira.lionschool.model.StudentsList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StudentsServices {

    //https://alive-bull-leotard.cyclic.app/v1/lion-school/

    @GET("alunos")
    fun getCoursesStudents(@Query("cursos") studentsCourses : String ) : retrofit2.Call<StudentsList>

    @GET("alunos/{matricula}")
    fun getAlunosByMatricula(@Path("matricula") matricula: String): retrofit2.Call<Student>
}