package com.example.inputpengguna

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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


    Column(modifier = Modifier
        .padding(top = 70.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(id = R.string.regis),
            fontSize = 35.sp,
            color = Color.Black
        )
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(width = 350.dp)
                .padding(top = 30.dp, start = 30.dp),
            label = {Text(text = "Nama Lengkap")},
            onValueChange = {textNama = it}
        )
        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier
                .width(width = 350.dp)
                .height(height = 100.dp)
                .padding(top = 30.dp, start = 30.dp),
            label = { Text(text = "Kota Asal") },
            onValueChange = {
                textAlamat = it
            }
        )


    }
}