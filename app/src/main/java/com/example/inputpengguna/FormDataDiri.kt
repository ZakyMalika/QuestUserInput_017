package com.example.inputpengguna

import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

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
    Box(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0x80A1BA), // biru muda di atas
                        Color(0xFF1976D2)  // biru tua di bawah
                    )
                )
            )   // 👈 Ganti warna background layar di sini
            .padding(16.dp)
            .fillMaxSize())

    Column(modifier = Modifier
        .padding(top=90.dp),
        verticalArrangement = Arrangement.Top,

        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(width = 350.dp),
            label = {Text(text = "Nama Lengkap")},
            onValueChange = {textNama = it}
        )
        Row {
            gender.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = textJK == item,
                    onClick = {textJK=item}
                ), verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = textJK == item,
                        onClick = {
                            textJK = item
                        }
                    )
                    Text(item)
                }
            }
        }
        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier
                .width(width = 350.dp)
                .height(height = 100.dp),
            label = { Text(text = "Alamat Lengkap") },
            onValueChange = {
                textAlamat = it
            }
        )
        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource(id = R.dimen.pad_med),
                top = dimensionResource(id = R.dimen.pad_med)
            ),
            thickness = dimensionResource(id = R.dimen.pad_tipis),
            color = Color.DarkGray
        )
        Button(
            modifier = Modifier.fillMaxWidth( ),
            enabled = textAlamat.isNotEmpty(),
            onClick = {
                Nama = textNama
                Alamat = textAlamat
                JK = textJK
            }
        ) {
            Text(text = stringResource(id = R.string.submit))
        }
        HorizontalDivider(
                modifier = Modifier.padding(
                    bottom = dimensionResource(id = R.dimen.pad_med),
                    top = dimensionResource(id = R.dimen.pad_med)
                ),
        thickness = dimensionResource(id = R.dimen.pad_tipis),
        color = Color.DarkGray
        )
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .height(100.dp)
                .width(350.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,
                        vertical = 15.dp)
            ) {
                Text(text = "Nama : $Nama", color = Color.White)
                Text(text = "Jenis Kelamin : $JK", color = Color.White)
                Text(text = "Alamat : $Alamat", color = Color.White)
            }
          }

    }
}