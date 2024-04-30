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

    private var person = Person()
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
        person = Person()
    }


    @Test
    fun `Durance puts some items in his inventory`(){

        val itemsExpectedInBackpack = listOf(
            "Leather", "Iron", "Cooper", "Marigold",
            "Wool", "Gold", "Silk", "Cooper"
        )
        val itemsExpectedInBag = listOf("Cooper", "Cherry Blossom")

        person.addSomeItems(itemsList)

        assertThat(itemsExpectedInBackpack)
            .containsExactlyInAnyOrderElementsOf(
                person.getItemNamesBag(person.getBagByCategory(Category.BACKPACK)
                ))
        assertThat(itemsExpectedInBag)
            .containsExactlyInAnyOrderElementsOf(
                person.getItemNamesBag(person.getBagByCategory(Category.METALS)
                ))
    }

    @Test
    fun `Durance casts the spell to organise his inventory`(){
        val itemsExpectedInBackpack = listOf("Iron")
        val itemsExpectedInBagMetal = listOf("Cooper", "Cooper", "Cooper", "Gold")
        val itemsExpectedInBagHerbs = listOf("Cherry Blossom", "Marigold")
        val itemsExpectedInBagClothes = listOf("Leather", "Silk", "Wool")

        person.addSomeItems(itemsList)
        person.organize()

        assertThat(itemsExpectedInBackpack)
            .containsExactlyInAnyOrderElementsOf(
                person.getItemNamesBag(person.getBagByCategory(Category.BACKPACK)
                ))
        assertThat(itemsExpectedInBagMetal)
            .containsExactlyInAnyOrderElementsOf(
                person.getItemNamesBag(person.getBagByCategory(Category.METALS)
                ))
        assertThat(itemsExpectedInBagHerbs)
            .containsExactlyInAnyOrderElementsOf(
                person.getItemNamesBag(person.getBagByCategory(Category.HERBS)
                ))
        assertThat(itemsExpectedInBagClothes)
            .containsExactlyInAnyOrderElementsOf(
                person.getItemNamesBag(person.getBagByCategory(Category.CLOTHES)
                ))
        assertEquals(0, person.getBagByCategory(Category.NONE).items.size)
    }


}