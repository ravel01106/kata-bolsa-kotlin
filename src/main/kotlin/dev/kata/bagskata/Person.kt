package dev.kata.bagskata

import dev.kata.bagskata.models.bags.*
import dev.kata.bagskata.models.category.Category
import dev.kata.bagskata.models.item.Item

class Person {
    private val inventory:MutableList<Bag> = mutableListOf(
        Backpack(), BagMetal(), BagNoneCategory(), BagClothes(), BagHerb()
    )

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

    fun addSomeItems(itemsList: Array<Item>) {
        itemsList.forEach { item: Item ->  addItem(item)}
    }


    fun organize() {
        val allItems = takingItemsOutFromBags()
        val restItem = getRestItems(allItems)
        val itemsWithCategories = getItemsDividedPrincipalCategories(allItems)
        val backpackItem = getBagByCategory(Category.BACKPACK)

        for (itemsWithCategory in itemsWithCategories){
            val bagItem = getBagByCategory(itemsWithCategory[0].category)
            itemsWithCategory.forEach{ item: Item ->
                if (bagItem.items.size < bagItem.size)  bagItem.items.add(item)
                else backpackItem.items.add(item)
            }

        }
        backpackItem.items.addAll(restItem)

    }

    fun getBags(): MutableList<Bag> {
        return this.inventory
    }

    fun getBagByCategory(category:Category):Bag{
        return this.inventory.filter {isCategory(it, category)}[0]
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

    private fun getBagCategories(predicate:(Bag) -> Boolean): List<Category> {
        val categoryBags = mutableListOf<Category>()
        val listBagFiltered = inventory.filter(predicate)
        listBagFiltered.forEach{ bag: Bag ->  categoryBags.add(bag.category)}
        return categoryBags.toList()
    }

    private fun getItemsDividedPrincipalCategories(itemList:List<Item>):List<List<Item>> {
        val itemsDividedCategories = mutableListOf<List<Item>>()
        val categories = getBagCategories { bag: Bag ->
            bag.category != Category.BACKPACK &&
                    bag.category != Category.NONE }

        categories.forEach{ category: Category ->
            itemsDividedCategories.add(getItemsByCategory(itemList, category))
        }
        return itemsDividedCategories.toList()
    }

    private fun getItemsByCategory(itemList:List<Item>, category:Category):List<Item> {
        return itemList.filter { item: Item -> item.category == category }
    }

    private fun getRestItems (itemList:List<Item>):List<Item> {
        val restItems = mutableListOf<Item>()
        itemList.forEach{item: Item ->  if (checkNotBelongPrincipalCategories(item)) restItems.add(item)}
        return restItems.toList()
    }

    private fun checkNotBelongPrincipalCategories (item:Item): Boolean {
        val categories = getBagCategories { bag: Bag ->
            bag.category != Category.BACKPACK && bag.category != Category.NONE }
        var notBelongThePrincipalCategories = true

        categories.forEach{ category: Category ->
            if (item.category == category) notBelongThePrincipalCategories = false
        }

        return notBelongThePrincipalCategories
    }

    private fun clearBag (bag:Bag) {
        bag.items.clear()
    }

    private fun takingItemsOutFromBags(): List<Item>{
        val allItems = mutableListOf<Item>()
        for (category in getBagCategories()){
            val bagItems = getBagByCategory(category)
            allItems.addAll(bagItems.items)
            clearBag(bagItems)
        }
        return allItems.toList()
    }

    private fun isCategory(bag:Bag, category:Category):Boolean{
        return bag.category == category
    }

}