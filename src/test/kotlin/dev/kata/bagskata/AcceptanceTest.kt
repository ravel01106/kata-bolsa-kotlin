package dev.kata.bagskata
import dev.kata.bagskata.models.item.Item
import dev.kata.bagskata.models.category.Category
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertTrue

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

        val itemsExpectedInBackpack = listOf(
            "Leather", "Iron", "Cooper", "Marigold",
            "Wool", "Gold", "Silk", "Cooper"
        )
        val itemsExpectedInBag = listOf("Cooper", "Cherry Blossom")

        durance.addSomeItems(itemsList);

        assertThat(itemsExpectedInBackpack)
            .containsExactlyInAnyOrderElementsOf(
                durance.getItemNamesBag(durance.getBagByCategory(Category.BACKPACK)
                ))
        assertThat(itemsExpectedInBag)
            .containsExactlyInAnyOrderElementsOf(
                durance.getItemNamesBag(durance.getBagByCategory(Category.METALS)
                ))
    }

    @Test
    fun `Durance casts the spell to organise his inventory`(){
        val itemsExpectedInBackpack = listOf("Iron")
        val itemsExpectedInBagMetal = listOf("Copper", "Copper", "Copper", "Gold")
        val itemsExpectedInBagHerbs = listOf("Cherry Blossom", "Marigold")
        val itemsExpectedInBagClothes = listOf("Leather", "Silk", "Wool")

        durance.addSomeItems(itemsList);
        durance.organize()

        assertThat(itemsExpectedInBackpack)
            .containsExactlyInAnyOrderElementsOf(
                durance.getItemNamesBag(durance.getBagByCategory(Category.BACKPACK)
                ))
        assertThat(itemsExpectedInBagMetal)
            .containsExactlyInAnyOrderElementsOf(
                durance.getItemNamesBag(durance.getBagByCategory(Category.METALS)
                ))
        assertThat(itemsExpectedInBagHerbs)
            .containsExactlyInAnyOrderElementsOf(
                durance.getItemNamesBag(durance.getBagByCategory(Category.HERBS)
                ))
        assertThat(itemsExpectedInBagClothes)
            .containsExactlyInAnyOrderElementsOf(
                durance.getItemNamesBag(durance.getBagByCategory(Category.CLOTHES)
                ))
        assertEquals(0, durance.getBagByCategory(Category.NONE).items.size)
    }


}