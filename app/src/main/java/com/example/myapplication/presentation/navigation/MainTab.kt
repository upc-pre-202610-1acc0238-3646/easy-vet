package com.example.myapplication.presentation.navigation

import com.example.myapplication.R

enum class MainTab (
    val label: String,
    val resourceId: Int
){
    Home(
        label = "Home",
        resourceId = R.drawable.home

    ),
    Favorites(
        label = "Favorites",
        resourceId = R.drawable.favorite
    ),
    Cart(
        label = "Cart",
        resourceId = R.drawable.shopping_cart
    ),
    Profile(
        label = "Profile",
        resourceId = R.drawable.person
    )

}