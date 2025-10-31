package com.example.inputpengguna

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import java.lang.reflect.Modifier

@Composable
fun FormDataDiri(modifier: Modifier){
//    variabel" untuk mengingat data
    var textNama by remember { mutableStateOf(value = " ") }
    var textAlamat by remember { mutableStateOf(value = " ") }
    var textJK by remember { mutableStateOf(value = " ") }

//    variabel" menyimpan
    var Nama by remember { mutableStateOf(value = " ") }
    var Alamat by remember { mutableStateOf(value = " ") }
    var JK by remember { mutableStateOf(value = " ") }

    val gender:List<String> = listOf("Laki-laki","Perempuan")
}