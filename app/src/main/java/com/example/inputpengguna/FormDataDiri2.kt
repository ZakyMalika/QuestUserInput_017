package com.example.inputpengguna

import android.R.attr.checked
import android.icu.util.Calendar
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.dimensionResource

@Composable
//kalau bisa ceklis baru bisa di submit,
//pake selctedDate untuk tanggal,
//semuanya di dalam variabel(+- 10 lebih variabel),
//pake verticaldefider,
//umur menggunakan scrolling,
//pake boolen untuk check box,(soalnya true or false),
//NILAI TAMBAH: kalau bisa menampilkan pop up hasil datanya
fun datadiri(modifier: Modifier){
    var textNama by remember { mutableStateOf(value = " ") }
    var textAlamat by remember { mutableStateOf(value = " ") }
    var textTanggal by remember { mutableStateOf(value = " ") }
    var textRT by remember { mutableStateOf(value = " ") }
    var textRW by remember { mutableStateOf(value = " ") }
    var textUmur by remember { mutableStateOf(value = " ") }
    var textJK by remember { mutableStateOf(value = " ") }

//    variabel" menyimpan
    var Nama by remember { mutableStateOf(value = " ") }
    var Alamat by remember { mutableStateOf(value = " ") }
    var Tanggal by remember { mutableStateOf(value = " ") }
    var RT by remember { mutableStateOf(value = " ") }
    var RW by remember { mutableStateOf(value = " ") }
    var Umur by remember { mutableStateOf(value = " ") }
    var JK by remember { mutableStateOf(value = " ") }


    var checked by remember { mutableStateOf(false) }

    val gender:List<String> = listOf("Laki-laki","Perempuan")
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val selectedDate = remember { mutableStateOf("") }

    val datePickerDialog = DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDayOfMonth ->
            val pickedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
            selectedDate.value = pickedDate
        },
        year,
        month,
        day
    )

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

//        alamat
        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .width(width = 350.dp)
                .height(height = 100.dp)
                .padding(top = 30.dp, start = 30.dp),
            label = { Text(text = "Kota Asal") },
            onValueChange = {
                textAlamat = it
            }
        )


        Row(modifier = Modifier) {
            //        tanggal
            OutlinedTextField(
                value = selectedDate.value,
                onValueChange = { },
                label = { Text("Tanggal Lahir") },
                readOnly = true,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .padding(top = 30.dp)
                    .clickable { datePickerDialog.show() },
                singleLine = true,
                trailingIcon = {
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = "Pilih tanggal")
                }
            )
//            RT
            OutlinedTextField(
                value = textRT,
                singleLine = true,
                modifier = Modifier
                    .width(width = 100.dp)
                    .height(height = 100.dp)
                    .padding(top = 30.dp, start = 30.dp),
                label = { Text(text = "RT") },
                onValueChange = {
                    textRT = it
                }
            )

            Spacer(modifier = Modifier.width(width = 20.dp))

            VerticalDivider(
                modifier = Modifier
                    .height(height = 120.dp)
                    .padding(
                    bottom = dimensionResource(id = R.dimen.pad_med),
                    top = dimensionResource(id = R.dimen.pad_med),
                ),
                thickness = dimensionResource(id = R.dimen.pad_tipis),
                color = Color.DarkGray,

            )
//            RW
            OutlinedTextField(
                value = textRW,
                singleLine = true,
                modifier = Modifier
                    .width(width = 100.dp)
                    .height(height = 100.dp)
                    .padding(top = 30.dp, start = 30.dp),
                label = { Text(text = "RW") },
                onValueChange = {
                    textRW = it
                }
            )



        }

//            UMUR
        OutlinedTextField(
            value = textUmur,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .width(width = 350.dp)
                .height(height = 100.dp)
                .padding(top = 30.dp, start = 30.dp),
            label = { Text(text = "Umur") },
            onValueChange = {
                textUmur = it
            }
        )

//        tinggi spacer
        Spacer(modifier = Modifier.height(height = 20.dp))

//        text untuk memanggil jenis kelamin
        Text(text = stringResource(id = R.string.jk),
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 20.dp)
        )

//        radio button jenis kelamin
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

//        membuat row
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 30.dp, start = 30.dp)
        ) {
//            membuat checkbox
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                modifier = Modifier.scale(1.3f),
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF3F51B5),
                    uncheckedColor = Color.Gray
                )
            )

//            text ketentuan
            Text(text = stringResource(id = R.string.cek),
            )
        }

//        button
        Button(
            modifier = Modifier.fillMaxWidth( ),
            enabled = textAlamat.isNotEmpty(),
            onClick = {
                Nama = textNama
                Alamat = textAlamat
                JK = textJK
                Tanggal = textTanggal
                RT = textRT
                RW = textRW
                Umur = textUmur
            }
        ) {
            Text(text = stringResource(id = R.string.submit))
        }



    }
}