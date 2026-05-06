package pe.edu.upc.easyvet.home.data.mapper

import pe.edu.upc.easyvet.home.data.local.ProductEntity
import pe.edu.upc.easyvet.home.data.remote.ProductDto
import pe.edu.upc.easyvet.home.domain.model.Product

fun ProductDto.toEntity(): ProductEntity {
    return ProductEntity(
        id = id,
        name = title,
        image = image,
        description = description
    )
}

fun ProductEntity.toDomain(): Product {
    return Product(
        id = id,
        name = name,
        image = image,
        description = description
    )
}