package com.example.inputpengguna

import android.app.DatePickerDialog
import java.util.Calendar
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun datadiri(modifier: Modifier) {

    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textTanggal by remember { mutableStateOf("") }
    var textRT by remember { mutableStateOf("") }
    var textRW by remember { mutableStateOf("") }
    var textUmur by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }

    // variabel untuk menyimpan hasil
    var Nama by remember { mutableStateOf("") }
    var Alamat by remember { mutableStateOf("") }
    var Tanggal by remember { mutableStateOf("") }
    var RT by remember { mutableStateOf("") }
    var RW by remember { mutableStateOf("") }
    var Umur by remember { mutableStateOf("") }
    var JK by remember { mutableStateOf("") }

    var checked by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) } // TAMBAHAN: untuk kontrol pop-up

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val context = LocalContext.current

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    // buat date picker
    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                val pickedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                textTanggal = pickedDate
            },
            year, month, day
        )
    }

    Column(
        modifier = Modifier.padding(top = 70.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.regis),
            fontSize = 35.sp,
            color = Color.Black
        )

        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .width(350.dp)
                .padding(top = 30.dp, start = 30.dp),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = { textNama = it }
        )

        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .width(350.dp)
                .height(100.dp)
                .padding(top = 30.dp, start = 30.dp),
            label = { Text(text = "Kota Asal") },
            onValueChange = { textAlamat = it }
        )

        Row {
            // TextField tanggal make clickable yang udah betul
            OutlinedTextField(
                value = textTanggal,
                onValueChange = { },
                label = { Text("Tanggal Lahir") },
                readOnly = true,
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = { datePickerDialog.show() }) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Pilih tanggal"
                        )
                    }
                },
                modifier = Modifier
                    .width(120.dp)
                    .height(100.dp)
                    .padding(top = 30.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        datePickerDialog.show()
                    }
            )

            // rt
            OutlinedTextField(
                value = textRT,
                singleLine = true,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .padding(top = 30.dp, start = 30.dp),
                label = { Text(text = "RT") },
                onValueChange = { textRT = it }
            )

            Spacer(modifier = Modifier.width(20.dp))

            VerticalDivider(
                modifier = Modifier
                    .height(120.dp)
                    .padding(
                        bottom = dimensionResource(id = R.dimen.pad_med),
                        top = dimensionResource(id = R.dimen.pad_med),
                    ),
                thickness = dimensionResource(id = R.dimen.pad_tipis),
                color = Color.DarkGray,
            )

            // rw
            OutlinedTextField(
                value = textRW,
                singleLine = true,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .padding(top = 30.dp, start = 30.dp),
                label = { Text(text = "RW") },
                onValueChange = { textRW = it }
            )
        }

        OutlinedTextField(
            value = textUmur,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .width(350.dp)
                .height(100.dp)
                .padding(top = 30.dp, start = 30.dp),
            label = { Text(text = "Umur") },
            onValueChange = { textUmur = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.jk),
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 20.dp)
        )

        Row {
            gender.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = textJK == item,
                        onClick = { textJK = item }
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = textJK == item, onClick = { textJK = item })
                    Text(item)
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 30.dp, start = 30.dp)
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                modifier = Modifier.scale(1.3f),
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF3F51B5),
                    uncheckedColor = Color.Gray
                )
            )

            Text(text = stringResource(id = R.string.cek))
        }

        Spacer(modifier = Modifier.height(50.dp))


        Button(
            modifier = Modifier.width(250.dp),
            enabled = textNama.isNotEmpty() && checked,
            onClick = {
                Nama = textNama
                Alamat = textAlamat
                JK = textJK
                Tanggal = textTanggal
                RT = textRT
                RW = textRW
                Umur = textUmur
                showDialog = true // untk menampilkan dialog
            }
        ) {
            Text(text = stringResource(id = R.string.submit))
        }

//        membuat alert
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = {
                    Text(
                        text = "Data Registrasi",
                        fontSize = 22.sp,
                        color = Color(0xFF3F51B5)
                    )
                },
                text = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Text(
                            text = "Nama Lengkap:",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        Text(
                            text = Nama,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )

                        Text(
                            text = "Kota Asal:",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        Text(
                            text = Alamat,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )

                        Text(
                            text = "Tanggal Lahir:",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        Text(
                            text = Tanggal,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )

                        Text(
                            text = "RT / RW:",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        Text(
                            text = "$RT / $RW",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )

                        Text(
                            text = "Umur:",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        Text(
                            text = "$Umur tahun",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )

                        Text(
                            text = "Jenis Kelamin:",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        Text(
                            text = JK,
                            fontSize = 16.sp
                        )
                    }
                },
                confirmButton = {
                    Button(
                        onClick = { showDialog = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF3F51B5)
                        )
                    ) {
                        Text("OK")
                    }
                }
            )
        }
    }
}