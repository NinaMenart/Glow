package com.example.glowskin.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.glowskin.comps.CounterText
import com.example.glowskin.comps.EmptyRoutineText
import com.example.glowskin.comps.Routine
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RoutineViewModel : ViewModel() {
    private var _routineList = mutableStateOf(emptyList<Routine>())
    val routineList: State<List<Routine>> = _routineList

    fun addRoutine(routine: Routine) {
        _routineList.value = _routineList.value + routine

    }
}

@Composable
fun RoutineListScreen(viewModel: RoutineViewModel) {
    val routineList by viewModel.routineList

    LazyColumn(state = rememberLazyListState()) {
        if (routineList.isEmpty()) {
            item {
                Log.d("ROUTINE", "EMPTY")
                EmptyRoutineText("Prazna rutina")
            }
        } else {
            item {
                CounterText( "Število izdelkov v rutini: ${routineList.size}")
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            itemsIndexed(routineList) { index, routine ->
                RoutineCard(routine, index + 1)
            }
        }
    }
}




@Composable
fun AddButtonWithDialog(viewModel: RoutineViewModel) {
    var isAddDialogVisible by remember { mutableStateOf(false) }
    var title by remember { mutableStateOf("") }
    var shortDescription by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { isAddDialogVisible = true },
            modifier = Modifier.padding(8.dp),
        ) {
            Text("Dodaj novo")
        }
    }

        if (isAddDialogVisible) {
            AlertDialog(
                onDismissRequest = {
                    isAddDialogVisible = false
                    title = ""
                    shortDescription = ""
                },
                text = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Button(
                                onClick = {
                                    isAddDialogVisible = false
                                    title = ""
                                    shortDescription = ""
                                },
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .wrapContentHeight()
                                    .padding(1.dp)
                            ) {
                                Text("X")
                            }
                        }

                        OutlinedTextField(
                            value = title,
                            onValueChange = { title = it },
                            label = { Text("Ime") },
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        OutlinedTextField(
                            value = shortDescription,
                            onValueChange = { shortDescription = it },
                            label = { Text("Opis") },
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            val newRoutine = Routine(title, shortDescription)
                            viewModel.addRoutine(newRoutine)
                            isAddDialogVisible = false
                            title = ""
                            shortDescription = ""
                        },
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                            .padding(8.dp)
                    ) {
                        Text("Dodaj")
                    }
                }
            )
        }
    }



@Composable
fun RoutineCard(routine: Routine, i: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = routine.title, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = routine.shortDescription)
        }
    }
}
