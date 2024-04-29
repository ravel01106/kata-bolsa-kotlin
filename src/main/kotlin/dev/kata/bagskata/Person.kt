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

    fun addItem(item: Item) {
        val hasBeenPutInBackpack = addItemInBackpack(item)
        if (!hasBeenPutInBackpack){
            addItemInBag(item)
        }
    }

    private fun addItemInBackpack(item:Item):Boolean{
        val backpackItems = getBagByCategory(Category.BACKPACK).items
        if (backpackItems.size < 8){
            backpackItems.add(item)
            return true
        }
        return false
    }
    private fun addItemInBag(item:Item):Boolean{
        val categoryBags = arrayOf(Category.METALS, Category.NONE, Category.CLOTHES, Category.HERBS)
        for (category in categoryBags){
            val bagItems = getBagByCategory(category).items
            if (bagItems.size < 4){
                bagItems.add(item)
                return true
            }
        }
        return false

    }

    private fun isCategory(bag:Bag, category:Category):Boolean{
        return bag.category == category
    }
    fun getBagByCategory(category:Category):Bag{
        return this.inventory.filter {isCategory(it, category)}[0]
    }
}