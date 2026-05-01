package pe.edu.upc.easyvet.home.data

import pe.edu.upc.easyvet.R
import pe.edu.upc.easyvet.home.domain.Category


object FakeData {

    val categories = listOf(
        Category(
            1,
            R.drawable.dogcategory,
            "Dog"
        ),
        Category(
            2,
            R.drawable.catcategory,
            "Cat"
        ),
        Category(
            3,
            R.drawable.birdcategory,
            "Bird"
        ),
        Category(
            4,
            R.drawable.fishcategory,
            "Fish"
        ),

    )
}