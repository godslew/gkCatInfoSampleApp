package org.godslew.gkcatinfosampleapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.godslew.gkcatinfosampleapp.presentation.CatViewModel
import org.koin.compose.viewmodel.koinViewModel

import gkcatinfosampleapp.composeapp.generated.resources.Res
import gkcatinfosampleapp.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewModel = koinViewModel<CatViewModel>()
        val uiState by viewModel.uiState.collectAsState()
        
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(Res.drawable.compose_multiplatform),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            when {
                uiState.isLoading -> {
                    CircularProgressIndicator()
                    Text("Loading cat information...", modifier = Modifier.padding(top = 8.dp))
                }
                uiState.catInfo != null -> {
                    uiState.catInfo?.let { catInfo ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(
                                    text = "Cat Information",
                                    style = MaterialTheme.typography.headlineMedium
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text("Name: ${catInfo.name}")
                                Text("Age: ${catInfo.age} years")
                                Text("Breed: ${catInfo.breed}")
                                Text("Description: ${catInfo.description}")
                            }
                        }
                    }
                }
            }
        }
    }
}