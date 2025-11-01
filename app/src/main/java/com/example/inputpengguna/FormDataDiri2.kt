package com.example.inputpengguna

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import java.lang.reflect.Modifier

@Composable
//kalau bisa ceklis baru bisa di submit,
//pake selctedDate untuk tanggal,
//semuanya di dalam variabel(+- 10 lebih variabel),
//pake defider,
//umur menggunakan scrolling,
//pake boolen untuk check box,(soalnya true or false),
//NILAI TAMBAH: kalau bisa menampilkan pop up hasil datanya
fun datadiri(modifier: Modifier){
    var textNama by remember { mutableStateOf(value = " ") }
    var textAlamat by remember { mutableStateOf(value = " ") }
    var textTanggal by remember { mutableStateOf(value = " ") }
    var textRT by remember { mutableStateOf(value = " ") }
    var textRW by remember { mutableStateOf(value = " ") }
    var textJK by remember { mutableStateOf(value = " ") }

//    variabel" menyimpan
    var Nama by remember { mutableStateOf(value = " ") }
    var Alamat by remember { mutableStateOf(value = " ") }
    var Tanggal by remember { mutableStateOf(value = " ") }
    var RT by remember { mutableStateOf(value = " ") }
    var RW by remember { mutableStateOf(value = " ") }
    var JK by remember { mutableStateOf(value = " ") }

    val gender:List<String> = listOf("Laki-laki","Perempuan")


    Column() {

    }
}