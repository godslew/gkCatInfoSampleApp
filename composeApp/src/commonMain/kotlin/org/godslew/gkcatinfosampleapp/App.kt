package org.godslew.gkcatinfosampleapp

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.compose.setSingletonImageLoaderFactory
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.godslew.gkcatinfosampleapp.presentation.CatViewModel
import org.godslew.gkcatinfosampleapp.theme.AppTheme
import org.koin.compose.viewmodel.koinViewModel
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    val imageLoader = koinInject<ImageLoader>()
    setSingletonImageLoaderFactory { context ->
        imageLoader
    }
    
    AppTheme {
        val viewModel = koinViewModel<CatViewModel>()
        val uiState by viewModel.uiState.collectAsState()
        
        val infiniteTransition = rememberInfiniteTransition(label = "refresh")
        val rotation by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            ),
            label = "rotation"
        )
        
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Cat Gallery") },
                    actions = {
                        IconButton(
                            onClick = { viewModel.refresh() },
                            enabled = !uiState.isLoading
                        ) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Refresh",
                                modifier = Modifier.rotate(if (uiState.isLoading) rotation else 0f)
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                when {
                    uiState.isLoading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                CircularProgressIndicator()
                                Text(
                                    "Loading cat images...",
                                    modifier = Modifier.padding(top = 8.dp)
                                )
                            }
                        }
                    }
                    uiState.error != null -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    "Error: ${uiState.error}",
                                    color = MaterialTheme.colorScheme.error
                                )
                                Button(
                                    onClick = { viewModel.refresh() },
                                    modifier = Modifier.padding(top = 8.dp)
                                ) {
                                    Text("Retry")
                                }
                            }
                        }
                    }
                    else -> {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            contentPadding = PaddingValues(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(uiState.catImages) { catImage ->
                                Card(
                                    modifier = Modifier.aspectRatio(1f),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                                ) {
                                    AsyncImage(
                                        model = catImage.url,
                                        contentDescription = "Cat image",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}