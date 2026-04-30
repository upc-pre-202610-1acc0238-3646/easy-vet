package com.example.myapplication.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.myapplication.presentation.components.CategoryItem
import com.example.myapplication.data.FakeData.categories
import com.example.myapplication.domain.Product

@Composable
fun Home(
    homeViewModel: HomeViewModel,
    modifier: Modifier = Modifier,
    onProductClick: (Product) -> Unit = {}
) {

    val state = homeViewModel.homeState.collectAsState().value

    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Categories",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )


        LazyRow {
            items(categories) {
                CategoryItem(it)

            }
        }


        when {
            state.isLoading -> {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()

                }
            }

            state.error != null -> {
                Text(text = state.error)
            }

            state.products.isEmpty() -> {
                Text(text = "No products found")
            }

            else -> {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(state.products) { product ->
                        ProductCard(product) {
                            onProductClick(product)
                        }
                    }
                }
            }

        }


    }

}

