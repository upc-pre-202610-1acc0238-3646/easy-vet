package pe.edu.upc.easyvet.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import pe.edu.upc.easyvet.di.RepositoryModule.provideProductRepository
import pe.edu.upc.easyvet.domain.Product
import pe.edu.upc.easyvet.presentation.home.Home
import pe.edu.upc.easyvet.presentation.home.HomeViewModel
import pe.edu.upc.easyvet.presentation.home.HomeViewModelFactory


@Composable
fun HomeNavHost() {

    val navController = rememberNavController()
    val factory = HomeViewModelFactory(provideProductRepository()).create()
    val viewModel: HomeViewModel = viewModel(factory = factory)

    val selectedProduct = remember {
        mutableStateOf<Product?>(null)
    }

    NavHost(
        navController = navController,
        startDestination = "home",
    ) {

        composable("home") {
            Home(viewModel) { product ->
                selectedProduct.value = product
                navController.navigate("product_detail")
            }
        }


        composable("product_detail") {
            selectedProduct.value?.let { product ->

                Column {
                    AsyncImage(model = product.image, contentDescription = product.name)
                    Text(product.name)

                }

            }
        }
    }


}