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
    // Organise the inventory by having full backpack.
    // Organise the inventory by having 6 items of the same category.
    // Organise all inventory.
    var person = Person()
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
        Item("Axe", Category.WEAPONS),
        Item("Silver", Category.METALS),
        Item("Iron", Category.METALS),
        Item("Rose", Category.HERBS),
        Item("Silk", Category.CLOTHES),
        Item("Silver", Category.METALS),
        Item("Silk", Category.CLOTHES),
        Item("Iron", Category.METALS),
        Item("Gold", Category.METALS),
        Item("Seaweed", Category.HERBS),
        Item("Silk", Category.CLOTHES),
        Item("Iron", Category.METALS),
        Item("Gold", Category.METALS),
        Item("Seaweed", Category.HERBS),
    )

    @BeforeEach
    fun `Empty items` () {
        person = Person()
    }

    @Test
    fun `Add an item to the inventory`(){
        val item = Item("Iron", Category.METALS)

        person.addItem(item)

        assertEquals(1,person.getBagByCategory(Category.BACKPACK).items.size)
    }
    @Test
    fun `Add 10 items to the inventory` () {
        itemsList.copyOfRange(0,10).forEach { item: Item -> person.addItem(item) }

        assertEquals(8, person.getBagByCategory(Category.BACKPACK).items.size)
        assertEquals(2, person.getBagByCategory(Category.METALS).items.size)
    }
    @Test
    fun `Fill in all inventory` () {
        itemsList.forEach { item: Item -> person.addItem(item) }

        assertEquals(8, person.getBagByCategory(Category.BACKPACK).items.size)
        assertEquals(4, person.getBagByCategory(Category.METALS).items.size)
        assertEquals(4, person.getBagByCategory(Category.NONE).items.size)
        assertEquals(4, person.getBagByCategory(Category.CLOTHES).items.size)
        assertEquals(4, person.getBagByCategory(Category.HERBS).items.size)

    }
    @Test
    fun `Organise the inventory by having full backpack`() {
        itemsList.copyOfRange(0,8).forEach { item: Item -> person.addItem(item) }
        person.organize()
        assertEquals(0, person.getBagByCategory(Category.BACKPACK).items.size)
        assertEquals(4, person.getBagByCategory(Category.METALS).items.size)
        assertEquals(3, person.getBagByCategory(Category.CLOTHES).items.size)
        assertEquals(1, person.getBagByCategory(Category.HERBS).items.size)
        assertEquals(0, person.getBagByCategory(Category.NONE).items.size)
    }
    @Test
    fun `Organise the inventory by having 6 items of the same category`() {
        itemsList.copyOfRange(0,12).forEach { item: Item -> person.addItem(item) }
        person.organize()
        assertEquals(3, person.getBagByCategory(Category.BACKPACK).items.size)
        assertEquals(4, person.getBagByCategory(Category.METALS).items.size)
        assertEquals(3, person.getBagByCategory(Category.CLOTHES).items.size)
        assertEquals(2, person.getBagByCategory(Category.HERBS).items.size)
        assertEquals(0, person.getBagByCategory(Category.NONE).items.size)
    }
    @Test
    fun `Organise all inventory`(){
        itemsList.forEach { item: Item -> person.addItem(item) }
        person.organize()
        assertEquals(8, person.getBagByCategory(Category.BACKPACK).items.size)
        assertEquals(4, person.getBagByCategory(Category.METALS).items.size)
        assertEquals(4, person.getBagByCategory(Category.CLOTHES).items.size)
        assertEquals(4, person.getBagByCategory(Category.HERBS).items.size)
        assertEquals(4, person.getBagByCategory(Category.NONE).items.size)

    }




}