package br.senai.sp.jandira.lionschool

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.model.CoursesList
import br.senai.sp.jandira.lionschool.service.RetofitiFactory
import br.senai.sp.jandira.lionschool.ui.theme.ui.theme.LionSchoolTheme
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Courses : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                aaa()
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun aaa() {

    val context = LocalContext.current

    var listCourses by remember {
        mutableStateOf(listOf<br.senai.sp.jandira.lionschool.model.Courses>())
    }

    val call = RetofitiFactory().getCharacterService().getCourses()

    call.enqueue(object : Callback<CoursesList>{
        override fun onResponse(call: Call<CoursesList>, response: Response<CoursesList>) {
            listCourses = response.body()!!.cursos
        }

        override fun onFailure(call: Call<CoursesList>, t: Throwable) {
            Log.i("teste", "onFailure:${t.message} " )
        }
    })



    Surface() {
        Column(
            modifier =
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color(51, 71, 176)))
        {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = br.senai.sp.jandira.lionschool.R.drawable.logo),
                    contentDescription = "",
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp))

                Text(text = "Lion School",
                    modifier = Modifier.padding(5.dp),
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight(700) )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(
                    value = "", onValueChange = {},
                    modifier = Modifier
                        .width(330.dp)
                        .height(30.dp),
                    shape = RoundedCornerShape(16.dp),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.search
                            ),
                            contentDescription = "",
                            tint = colorResource(id = R.color.white)
                        )
                    }
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(
                    text = "Courses :", modifier = Modifier.padding(10.dp),
                    color = Color(234, 204, 47),
                    fontSize = 40.sp,
                    fontWeight = FontWeight(700)
                )

                Row(
                    modifier = Modifier
                        .height(1.dp)
                        .width(350.dp)
                        .background(color = Color.White)
                        .padding(150.dp)
                ) {
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp)
                ) {
                    items(listCourses) {
                        Spacer(modifier = Modifier.size(20.dp))
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .clickable{
                                    var openStudents = Intent(context, StudentsCourses::class.java)

                                    openStudents.putExtra("sigla", it.sigla)
                                    context.startActivity(openStudents)
                                },
                            backgroundColor = Color(208, 220, 238),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Row(modifier = Modifier.padding(10.dp)) {
                                AsyncImage(
                                    model = it.icone,
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(80.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column() {
                                    Text(
                                        text = it.sigla,
                                        fontSize = 35.sp,
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold,
                                    )
                                    Text(text = it.nome, fontSize = 15.sp)
                                }
                            }

                        }
                    }
                }
            }

        }
    }
}