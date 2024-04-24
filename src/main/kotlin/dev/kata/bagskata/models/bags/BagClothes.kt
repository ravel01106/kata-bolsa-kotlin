package dev.kata.bagskata.models.bags

import dev.kata.bagskata.models.category.Category
import dev.kata.bagskata.models.item.Item

data class BagClothes(
    override var items: MutableList<Item> = mutableListOf(),
    override var category: Category = Category.CLOTHES,
    override var size: Int = 4
):Bag()
