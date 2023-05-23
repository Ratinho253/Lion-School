package br.senai.sp.jandira.lionschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.ui.theme.ui.theme.LionSchoolTheme

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
                    items(6) {
                        Spacer(modifier = Modifier.size(20.dp))
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            backgroundColor = Color(208, 220, 238),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Row(modifier = Modifier.padding(10.dp)) {
                                Image(
                                    painter = painterResource(id = R.drawable.search),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(80.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column() {
                                    Text(
                                        text = "DS",
                                        fontSize = 35.sp,
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold,
                                    )
                                    Text(text = "Desenvolvimento de Sistemas", fontSize = 15.sp)
                                }
                            }

                        }
                    }
                }
            }

        }
    }
}