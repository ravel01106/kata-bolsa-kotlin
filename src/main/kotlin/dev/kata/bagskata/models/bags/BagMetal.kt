package dev.kata.bagskata.models.bags

import dev.kata.bagskata.models.category.Category
import dev.kata.bagskata.models.item.Item

data class BagMetal(
    override var items: MutableList<Item> = mutableListOf(),
    override var category: Category = Category.METALS,
    override var size: Int = 4
): Bag()