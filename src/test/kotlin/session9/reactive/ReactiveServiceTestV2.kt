package session9.reactive

import org.junit.jupiter.api.Test
import session9.assertions.assertErrorMessage
import session9.assertions.assertNextCount
import session9.assertions.assertNextElement
import session9.assertions.assertNextElements

class ReactiveServiceTestV2 {

    @Test
    fun `should return flux of strings with valid count`() {
        val reactiveService = ReactiveService()

        val result = reactiveService.asFlux(arrayOf("a", "b"))

        result.assertNextCount(2)
    }

    @Test
    fun `should return flux of given strings`() {
        val reactiveService = ReactiveService()

        val result = reactiveService.asFlux(arrayOf("a", "b"))

        result.assertNextElements("a", "b")
    }

    @Test
    fun `should return flux of integers with valid count`() {
        val reactiveService = ReactiveService()

        val result = reactiveService.asFlux(arrayOf(1, 2, 3))

        result.assertNextCount(3)
    }

    @Test
    fun `should return flux of integers`() {
        val reactiveService = ReactiveService()

        val result = reactiveService.asFlux(arrayOf(1, 2, 3))

        result.assertNextElements(1, 2, 3)
    }

    @Test
    fun `should return mono of string`() {
        val reactiveService = ReactiveService()

        val result = reactiveService.asMono("abc")

        result.assertNextElement("abc")
    }

    @Test
    fun `should return mono of error with message`() {
        val reactiveService = ReactiveService()

        val result = reactiveService.monoError("my custom error")

        result.assertErrorMessage("my custom error")
    }
}