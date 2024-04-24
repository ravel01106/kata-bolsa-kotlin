package dev.kata.bagskata
import dev.kata.bagskata.models.item.Item
import dev.kata.bagskata.models.category.Category
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AcceptanceTest {

    // Durance puts some items in his inventory
    // Durance casts the spell to organise his inventory.

    private var durance = Person()
    private val itemsList = arrayOf(
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
    fun `reset person `(){
        durance = Person()
    }


    @Test
    fun `Durance puts some items in his inventory`(){

        val itemsExpectedInBackpack = arrayOf(
            "Leather", "Iron", "Copper", "Marigold",
            "Wool", "Gold", "Silk", "Copper"
        )
        val itemsExpectedInBag = arrayOf("Copper", "Cherry Blossom")

        durance.addSomeItems(itemsList);

        //assertEquals(itemsExpectedInBackpack, durance.getBackpack().getItemsName())
        //assertEquals(itemsExpectedInBag, durance.getBackpack().getItemsName())


    }

    @Test
    fun `Durance casts the spell to organise his inventory`(){
        val itemsExpectedInBackpack = arrayOf(
            "Cherry Blossom", "Iron", "Leather",
            "Marigold","Silk", "Wool"
        )
        val itemsExpectedInBag = arrayOf("Copper", "Copper", "Copper", "Gold")

        durance.addSomeItems(itemsList);
        durance.organize()

        //assertEquals(itemsExpectedInBackpack, durance.getBackpack().getItemsName())
        //assertEquals(itemsExpectedInBag, durance.getBackpack().getItemsName())
    }


}