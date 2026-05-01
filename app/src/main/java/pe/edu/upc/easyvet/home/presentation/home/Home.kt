package pe.edu.upc.easyvet.home.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import pe.edu.upc.easyvet.home.data.FakeData.categories
import pe.edu.upc.easyvet.home.domain.Product
import pe.edu.upc.easyvet.home.presentation.components.CategoryItem


@Composable
fun Home(
    homeViewModel: HomeViewModel,
    modifier: Modifier = Modifier,
    onProductClick: (Product) -> Unit = {}
) {

    val state = homeViewModel.homeState.collectAsState().value

    Column(modifier = modifier.fillMaxSize().padding(8.dp)) {
        Text(
            text = "Categories",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )

        LazyRow(modifier = Modifier.padding(vertical = 8.dp)) {
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
                    items(state.products) {
                        ProductCard(product = it, onClick = { onProductClick(it) })
                    }
                }
            }

        }


    }

}

