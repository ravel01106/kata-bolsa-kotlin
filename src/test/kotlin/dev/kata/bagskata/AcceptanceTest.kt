package dev.kata.bagskata
import dev.kata.bagskata.models.Item
import dev.kata.bagskata.models.ItemCategory
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AcceptanceTest {

    // Durance puts some items in his inventory
    // Durance casts the spell to organise his inventory.
    private var durance = Person()
    private val itemsList = arrayOf(
        Item("Leather", ItemCategory.CLOTHES),
        Item("Iron", ItemCategory.METALS),
        Item("Cooper", ItemCategory.METALS),
        Item("Marigold", ItemCategory.HERBS),
        Item("Wool", ItemCategory.CLOTHES),
        Item("Gold", ItemCategory.METALS),
        Item("Silk", ItemCategory.CLOTHES),
        Item("Cooper", ItemCategory.METALS),
        Item("Cooper", ItemCategory.METALS),
        Item("Cherry Blossom", ItemCategory.HERBS),
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

        assertEquals(itemsExpectedInBackpack, durance.getBackpack().getItemsName())
        assertEquals(itemsExpectedInBag, durance.getBackpack().getItemsName())


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

        assertEquals(itemsExpectedInBackpack, durance.getBackpack().getItemsName())
        assertEquals(itemsExpectedInBag, durance.getBackpack().getItemsName())
    }


}