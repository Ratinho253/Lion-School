package br.senai.sp.jandira.lionschool

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme
import coil.compose.AsyncImage

class PerformanceStudents : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                PerformaceAluno()
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PerformaceAluno() {

    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color(51, 71, 176))
        ) {
            Spacer(modifier = Modifier.height(25.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "",
                    modifier = Modifier
                        .width(99.dp)
                        .height(99.dp))


                Text(text = "Lion School",
                    modifier = Modifier.padding(20.dp),
                    color = Color(234,204,47),
                    fontSize = 30.sp,
                    fontWeight = FontWeight(900) )
            }
            Spacer(modifier = Modifier.height(30.dp))

            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),) {

                Text(
                    text = "Performance",
                    modifier = Modifier.align(CenterHorizontally),
                    color = Color(234, 204, 47),
                    fontSize = 40.sp,
                    fontWeight = FontWeight(700)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
//                        .clickable{
//                            var openStudents = Intent(context, StudentsCourses::class.java)
//
//                            openStudents.putExtra("sigla", it.sigla)
//                            context.startActivity(openStudents)
//                        },
                    backgroundColor = Color(208, 220, 238),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(modifier = Modifier.padding(10.dp)) {
                        AsyncImage(
                            model = "",
                            contentDescription = "",
                            modifier = Modifier
                                .size(80.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column() {
                            Text(
                                text = "",
                                fontSize = 35.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(text = "", fontSize = 15.sp)
                        }
                    }

                }


            }
        }
    }
}