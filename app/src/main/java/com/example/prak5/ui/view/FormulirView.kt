package com.example.prak5.ui.view

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text


@Composable
fun FormulirView(
    modifier: Modifier = Modifier,
    pilihanJk: List<String>,
    onClickButton: (MutableList<String>) ->Unit,
    ) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisK by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") } //nambahkan nim
    var listData: MutableList<String> = mutableListOf(nama , jenisK, alamat,email,noHp,nim)



    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Biodata",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )
        Spacer(modifier = Modifier.padding(20.dp))
        TextField(
            value = nama,
            onValueChange = { nama = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = {
                Text("Nama")
            },
            placeholder = {
                Text("Masukkan Nama Anda")
            }
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            pilihanJk.forEach { selectedJK ->
                Row (verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = jenisK == selectedJK,
                        onClick = {
                            jenisK = selectedJK
                        })
                    Text(selectedJK)
                }

            }
        }
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = {
                Text("Email")
            },
            placeholder = {
                Text("Masukkan Email Anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = noHp,
            onValueChange = { noHp = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = {
                Text("No Handphone")
            },
            placeholder = {
                Text("Masukkan Nomor Handphone Anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text("Alamat")},
            placeholder = { Text("Masukkan Alamat Anda")}
        )

        TextField(
            value = nim,
            onValueChange = { nim = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = { Text ("NIM")},
            placeholder = {Text("Masukkan NIM anda")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )


        Button(onClick = {
            onClickButton(listData)
        }, modifier = Modifier.padding(vertical = 10.dp)){
            Text("Simpan")
        }

    }

}

