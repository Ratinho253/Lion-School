package br.senai.sp.jandira.lionschool


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                Home()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Home() {

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
            Spacer(modifier = Modifier.height(300.dp))

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

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {

                Row(modifier = Modifier
                    .height(1.dp)
                    .width(300.dp)
                    .background(color = Color.White)
                    .padding(150.dp)
                ) {
                }
                Text(
                    text = "Come see the course your",
                    color = Color(234,204,47),
                )
                Text(
                    text = "student is enrolled in",
                    color = Color(234,204,47),
                )
                Spacer(modifier = Modifier.height(220.dp))

                Button(
                    onClick = {
                        var openCourses = Intent(context,br.senai.sp.jandira.lionschool.Courses::class.java)
                        context.startActivity(openCourses)
                              },
                    shape = RoundedCornerShape(13.dp),
                    modifier =
                    Modifier
                        .height(48.dp)
                        .width(134.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white))
                ){
                    Text(
                        text = "Start",
                        color = Color(234,204,47),
                        fontSize = 25.sp,
                    )
                }
            }
        }
    }
}

//var openCourses = Intent(context, Cursos::class.java)
//                        context.startActivity(openCourses)