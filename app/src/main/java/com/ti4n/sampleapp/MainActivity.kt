package com.ti4n.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ti4n.sampleapp.db.DataBase
import com.ti4n.sampleapp.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Scaffold(floatingActionButton = {
                    Fab()
                }) {
                    Count()
                }
            }
        }
    }
}

@Composable
fun Fab(viewModel: MainViewModel = viewModel()) {
    FloatingActionButton(onClick = { viewModel.increase() }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = null)
    }
}

@Composable
fun Count(viewModel: MainViewModel = viewModel()) {
    val count by viewModel.count.collectAsState()
    Text(text = count.toString())
}

@HiltViewModel
class MainViewModel @Inject constructor(private val dataBase: DataBase) : ViewModel() {

    val count = MutableStateFlow(0)

    fun increase() {
        count.value = count.value + 1
    }
}