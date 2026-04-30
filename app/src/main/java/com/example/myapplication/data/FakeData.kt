package com.example.myapplication.data

import com.example.myapplication.domain.Category
import com.example.myapplication.R

object FakeData {

    val categories = listOf(
        Category(1, R.drawable.dogcategory, "Dog"),
        Category(2, R.drawable.catcategory, "Cat"),
        Category(3, R.drawable.birdcategory, "Bird"),
        Category(4, R.drawable.fishcategory, "Fish"),

    )
}