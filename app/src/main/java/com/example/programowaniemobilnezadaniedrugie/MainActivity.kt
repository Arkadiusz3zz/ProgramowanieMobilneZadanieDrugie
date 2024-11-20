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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
            navController.navigate("ekranDrugi")
        }) {
            Text(text = "Ekran Drugi")
        }
        Button(onClick = {
            navController.navigate("ekranTrzeci")
        }) {
            Text(text = "Ekran Trzeci")
        }
        Button(onClick = {
            navController.navigate("ekranCzwarty")
        }) {
            Text(text = "Ekran Czwarty")
        }
        }
    }}

@Composable
fun EkranDrugi(navController: NavController){
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
    }}

@Composable
fun EkranTrzeci(navController: NavController){
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
    }}

@Composable
fun EkranCzwarty(navController: NavController){
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
    }}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "EkranPierwszy") {
        composable("ekranPierwszy") {
            EkranGlowny(navController = navController)
        }
        composable("ekranDrugi") {
            EkranDrugi(navController = navController)
        }
        composable("ekranTrzeci") {
            EkranTrzeci(navController = navController)
        }
        composable("ekranCzwarty") {
            EkranCzwarty(navController = navController)
        }
    }
}