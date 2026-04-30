package com.example.myapplication.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.myapplication.di.RepositoryModule.provideProductRepository
import com.example.myapplication.domain.Product
import com.example.myapplication.presentation.home.Home
import com.example.myapplication.presentation.home.HomeViewModel
import com.example.myapplication.presentation.home.HomeViewModelFactory

@Composable
fun HomeNavHost() {

    val navController = rememberNavController()
    val factory = HomeViewModelFactory(provideProductRepository())
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