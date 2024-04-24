package dev.kata.bagskata.models.item

import dev.kata.bagskata.models.category.Category

data class Item(
    var name:String,
    var category: Category,
)