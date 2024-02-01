package org.example.shelob

import java.time.Instant

data class Product (
    val id: Long,

    val productName: String,

    val price: Long,

    val options: List<String>,

    val createdAt: Instant,

    val productType: ProductType,

    val merchantInfo: Map<Int, String>
)

enum class ProductType {
    ELECTRONICS,
    CLOTHING,
    FOOD
}
