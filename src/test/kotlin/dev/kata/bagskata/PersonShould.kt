package dev.kata.bagskata

import dev.kata.bagskata.models.category.Category
import dev.kata.bagskata.models.item.Item
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PersonShould {
    // Add an item to the inventory.
    // Add 9 items to the inventory.
    // Fill in all inventory.
    // Organise the inventory by having two full bags.
    // Organise the inventory by having 6 items of the same category.
    // Organise all inventory.

    @Test
    fun ` Add an item to the inventory`(){
        val durance = Person()

        durance.addItem(Item("Iron", Category.METALS))

        assertEquals(1,durance.getPack().filter { it.category== Category.BACKPACK }[0].items.size)
    }



}