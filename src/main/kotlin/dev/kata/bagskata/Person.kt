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

    fun getBags(): MutableList<Bag> {
        return this.inventory
    }

    fun addItem(item: Item) {
        getBagByCategory(Category.BACKPACK).items.add(item)
    }
    private fun isCategory(bag:Bag, category:Category):Boolean{
        return bag.category == category
    }
    fun getBagByCategory(category:Category):Bag{
        return this.inventory.filter {isCategory(it, category)}[0]
    }
}