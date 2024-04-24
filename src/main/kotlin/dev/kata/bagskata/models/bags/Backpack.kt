package dev.kata.bagskata.models.bags

import dev.kata.bagskata.models.item.Item
import dev.kata.bagskata.models.category.Category

data class Backpack(
    override var items:MutableList<Item> = mutableListOf(),
    override var category: Category = Category.BACKPACK,
    override var size: Int = 8
): Bag()