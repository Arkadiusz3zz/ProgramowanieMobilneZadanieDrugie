package com.example.programowaniemobilnezadaniedrugie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.programowaniemobilnezadaniedrugie.ui.theme.ProgramowanieMobilneZadanieDrugieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProgramowanieMobilneZadanieDrugieTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavGraph(navController = navController)

                }
            }
        }
    }
}

@Composable
fun EkranGlowny(navController: NavController){

    var text by remember { mutableStateOf(" ") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ekran Pierwszy",
            fontSize = 30.sp
        )
        Row(
            modifier = Modifier
        ) {
        Button(onClick = {
            navController.navigate("ekranDrugi/$text")
        }) {
            Text(text = "Ekran Drugi")
        }
        Button(onClick = {
            navController.navigate("ekranTrzeci/$text")
        }) {
            Text(text = "Ekran Trzeci")
        }
        Button(onClick = {
            navController.navigate("ekranCzwarty/$text")
        }) {
            Text(text = "Ekran Czwarty")
        }
        }
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
        )
    }}

@Composable
fun EkranDrugi(navController: NavController, text: String){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ekran Drugi",
            fontSize = 30.sp
        )
        Button(onClick = {
            navController.navigate("ekranPierwszy")
        }) {
            Text(text = "Powrót")
        }
        Text(
            text = "$text",
            fontSize = 30.sp
        )
    }}

@Composable
fun EkranTrzeci(navController: NavController, text: String){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ekran Trzeci",
            fontSize = 30.sp
        )
        Button(onClick = {
            navController.navigate("ekranPierwszy")
        }) {
            Text(text = "Powrót")
        }
        Text(
            text = "$text",
            fontSize = 30.sp
        )
    }}

@Composable
fun EkranCzwarty(navController: NavController, text: String){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ekran Czwarty",
            fontSize = 30.sp
        )
        Button(onClick = {
            navController.navigate("ekranPierwszy")
        }) {
            Text(text = "Powrót")
        }
        Text(
            text = "$text",
            fontSize = 30.sp
        )
    }}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "EkranPierwszy") {
        composable("ekranPierwszy") {
            EkranGlowny(navController = navController)
        }
        composable("ekranDrugi/{text}",
            arguments = listOf(navArgument("text") { type = NavType.StringType})
        ) {
            entry ->
            val text = entry.arguments?.getString("text") ?: "Unknown"
            EkranDrugi(navController = navController, text = text)
        }
        composable("ekranTrzeci/{text}",
            arguments = listOf(navArgument("text") { type = NavType.StringType})
            ) {
            entry ->
            val text = entry.arguments?.getString("text") ?: "Unknown"
            EkranTrzeci(navController = navController, text = text)
        }
        composable("ekranCzwarty/{text}",
            arguments = listOf(navArgument("text") { type = NavType.StringType})
            ) {
            entry ->
            val text = entry.arguments?.getString("text") ?: "Unknown"
            EkranCzwarty(navController = navController, text = text)
        }
    }
}