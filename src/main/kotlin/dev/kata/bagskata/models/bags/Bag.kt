package dev.kata.bagskata.models.bags
import dev.kata.bagskata.models.item.Item
import dev.kata.bagskata.models.category.Category

abstract class Bag {
    abstract var items:MutableList<Item>
    abstract var category:Category
    abstract var size:Int
}