package dev.kata.bagskata

import dev.kata.bagskata.models.category.Category
import dev.kata.bagskata.models.item.Item
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PersonShould {
    // Add an item to the inventory.
    // Add 10 items to the inventory.
    // Fill in all inventory.
    // Organise the inventory by having two full bags.
    // Organise the inventory by having 6 items of the same category.
    // Organise all inventory.
    var durance = Person()
    val itemsList = arrayOf(
        Item("Leather", Category.CLOTHES),
        Item("Iron", Category.METALS),
        Item("Cooper", Category.METALS),
        Item("Marigold", Category.HERBS),
        Item("Wool", Category.CLOTHES),
        Item("Gold", Category.METALS),
        Item("Silk", Category.CLOTHES),
        Item("Cooper", Category.METALS),
        Item("Cooper", Category.METALS),
        Item("Cherry Blossom", Category.HERBS),
    )

    @BeforeEach
    fun ` Reset durance` () {
        durance = Person()
    }

    @Test
    fun ` Add an item to the inventory`(){

        durance.addItem(Item("Iron", Category.METALS))

        assertEquals(1,durance.getBagByCategory(Category.BACKPACK).items.size)
    }
    @Test
    fun ` Add 10 items to the inventory` () {
        itemsList.forEach { item: Item -> durance.addItem(item) }
        assertEquals(8, durance.getBagByCategory(Category.BACKPACK).items.size)
        assertEquals(2, durance.getBagByCategory(Category.METALS).items.size)

    }
}