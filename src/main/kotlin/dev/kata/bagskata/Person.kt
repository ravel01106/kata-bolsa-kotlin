package dev.kata.bagskata

import dev.kata.bagskata.models.bags.*
import dev.kata.bagskata.models.category.Category
import dev.kata.bagskata.models.item.Item

class Person {
    private val inventory:MutableList<Bag> = mutableListOf(
        Backpack(), BagMetal(), BagNoneCategory(), BagClothes(), BagHerb()
    )
    fun addSomeItems(itemsList: Array<Item>) {
        itemsList.forEach { item: Item ->  addItem(item)}
    }

    fun organize() {
        TODO("Not yet implemented")
    }

    fun getBags(): MutableList<Bag> {
        return this.inventory
    }

    fun addItem(item: Item):Boolean {
        for (category in getBagCategories()){
            val bagItems = getBagByCategory(category)
            if (bagItems.items.size < bagItems.size){
                bagItems.items.add(item)
                return true
            }
        }
        return false
    }
    fun getItemNamesBag(bag:Bag):List<String> {
        val itemNamesBags = mutableListOf<String>()
        bag.items.forEach { item: Item ->  itemNamesBags.add(item.name)}
        return itemNamesBags.toList()

    }
    private fun getBagCategories (): List<Category> {
        val categoryBags = mutableListOf<Category>()
        inventory.forEach{ bag: Bag ->  categoryBags.add(bag.category)}
        return categoryBags.toList()
    }

    private fun isCategory(bag:Bag, category:Category):Boolean{
        return bag.category == category
    }
    fun getBagByCategory(category:Category):Bag{
        return this.inventory.filter {isCategory(it, category)}[0]
    }
}