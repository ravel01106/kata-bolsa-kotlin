package dev.kata.bagskata

import dev.kata.bagskata.models.bags.*
import dev.kata.bagskata.models.category.Category
import dev.kata.bagskata.models.item.Item

class Person {
    private val inventory:MutableList<Bag> = mutableListOf(
        Backpack(), BagMetal(), BagNoneCategory(), BagClothes(), BagHerb()
    )
    fun addSomeItems(itemsList: Array<Item>) {

    }

    fun organize() {
        TODO("Not yet implemented")
    }

    fun getPack(): MutableList<Bag> {
        return this.inventory
    }

    fun addItem(item: Item) {
        this.inventory.filter { it.category == Category.BACKPACK }[0].items.add(item)
    }
}