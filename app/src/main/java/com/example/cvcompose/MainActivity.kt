package com.example.cvcompose

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}

@Preview
@Composable
fun ViewContainer() {
    Scaffold(
        topBar = { Toolbar() },
        content = { Content() }


    )
}


@Composable
fun Toolbar() {

    TopAppBar(
        title = { Text(text = "CV DAVID RAMOS", color = colorResource(id = R.color.white)) },
        backgroundColor = colorResource(id = R.color.black)
    )


}


@Composable
fun DialogAlert() {

    var show by rememberSaveable { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(
            onClick = { show = true },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
        ) {
            Text(
                text = "CONTACTO",
                color = colorResource(id = R.color.green_android),
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }
    }
    MyDialog(show, { show = false }, { Log.i("yo", "click") })
}

@Composable
fun MyDialog(show: Boolean, onDimiss: () -> Unit, onConfirm: () -> Unit) {
    if (show) {
        AlertDialog(onDismissRequest = { onDimiss() },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "GitHub", color =  colorResource(id = R.color.green_android))
                    LinkGit()
                }
            },
            dismissButton = {
                TextButton(onClick = { onDimiss() }) {
                    Text(text = "Volver")
                }
            },
            title = { Text(text = "CONTACTO") },
            text = {
                Text(
                    text = "Celular: 922-214-2965 \n" +
                            "E-mail: alexramos@live.com.mx \n"
                )
            })

    }
}

@Composable

fun LinkGit() {
    val context = LocalContext.current

    Column {
        Text(
            "",
            modifier = Modifier.clickable {
                val url =
                    "https://github.com/DevDavidRamos?tab=repositories" // URL a la que deseas dirigir al usuario
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)
            }
        )
    }
}

@Composable
fun Content() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.Blue_Cv))
    ) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                painter = painterResource(id = R.drawable.ic_fotocv), contentDescription = "Mi foto"
            )

            Text(
                text = "David Ramos",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Sobre mi: ",
                fontSize = 14.sp,
                color = Color.White,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "Hola soy David desarrollador de " +
                        "aplicaciones android " +
                        "estoy emocionado por comenzar mi carrera y " +
                        "aplicar mis habilidades recién adquiridas en el desarrollo de aplicaciones móviles",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Justify
            )

            Text(
                text = "Educación: ",
                color = Color.White,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "2017-2023 ",
                color = Color.White,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,

                )
            Text(
                text = "Instituto Tecnológico de Minatitlán \n"
                        +
                        "Ingeniería en Sistemas Computacionales",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Conocimientos: ",
                color = Color.White,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(8.dp)
            )

            LazyRow(

                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(BorderStroke(4.dp, Color.White))
            ) {
                item {
                    Text(
                        text = "ANDROID STUDIO",
                        color = Color.White,
                        modifier = Modifier.padding(6.dp)
                    )
                    Text(text = "NETBEANS", color = Color.White, modifier = Modifier.padding(6.dp))
                    Text(
                        text = "KOTLIN(ANDROID)",
                        color = Color.White,
                        modifier = Modifier.padding(6.dp)
                    )
                    Text(
                        text = "JAVA(ANDROID, JAVA FX)",
                        color = Color.White,
                        modifier = Modifier.padding(6.dp)
                    )
                    Text(
                        text = "DAGGER – HILT",
                        color = Color.White,
                        modifier = Modifier.padding(6.dp)
                    )
                    Text(
                        text = "NAVIGATION COMPONENTS",
                        color = Color.White,
                        modifier = Modifier.padding(6.dp)
                    )
                    Text(
                        text = "COROUTINES",
                        color = Color.White,
                        modifier = Modifier.padding(6.dp)
                    )
                    Text(text = "RETROFIT2", color = Color.White, modifier = Modifier.padding(6.dp))
                    Text(
                        text = "GIT, GITHUB",
                        color = Color.White,
                        modifier = Modifier.padding(6.dp)
                    )
                    Text(text = "RxJAVA2", color = Color.White, modifier = Modifier.padding(6.dp))
                    Text(text = "MVVM", color = Color.White, modifier = Modifier.padding(6.dp))
                    Text(
                        text = "JETPACK COMPOSE",
                        color = Color.White,
                        modifier = Modifier.padding(6.dp)
                    )
                    Text(
                        text = "TEST UNITARIOS Junit",
                        color = Color.White,
                        modifier = Modifier.padding(6.dp)
                    )
                    Text(
                        text = "SQL (POSTGRESQL, ORACLE, SQL SERVER)",
                        color = Color.White,
                        modifier = Modifier.padding(6.dp)
                    )
                    Text(text = "FIREBASE", color = Color.White, modifier = Modifier.padding(6.dp))
                    Text(
                        text = "PROGRAMACIÓN (ORIENTADA A OBJETOS, LOGICA, FUNCIONAL)",
                        color = Color.White, modifier = Modifier.padding(6.dp)
                    )
                }
            }
            Text(
                text = "Experiencia",
                color = Color.White,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "Desarrollo de proyecto (Junio – Diciembre 2022) \n" +
                        "Residencias Profesionales \n" +
                        "Soc. Coop. Insurgentes Sur\n" +
                        "Minatitlán, Veracruz, México \n" +
                        "Tareas realizadas: \n" +
                        "Desarrollo de una aplicación móvil para el monitoreo de autobuses.",
                color = Color.White,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            DialogAlert()


        }
    }

}

