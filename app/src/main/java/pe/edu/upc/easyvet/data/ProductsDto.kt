package pe.edu.upc.easyvet.data

data class ProductsDto(
    val count: Int,
    val results: List<pe.edu.upc.easyvet.data.ProductDto>
)

data class ProductDto (
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val rating: Double,
    val image: String,
    val category: String,
    val stock: Int
)
