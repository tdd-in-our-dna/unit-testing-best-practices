package session9.reactive

import org.junit.jupiter.api.Test
import io.kotlintest.shouldBe
import reactor.test.StepVerifier

class ReactiveServiceTestV1 {

    @Test
    fun `should return flux of strings with count`() {
        val reactiveService = ReactiveService()

        val result = reactiveService.asFlux(arrayOf("a", "b"))

        StepVerifier
            .create(result)
            .expectSubscription()
            .expectNextCount(2)
            .verifyComplete()
    }

    @Test
    fun `should return flux of strings`() {
        val reactiveService = ReactiveService()

        val result = reactiveService.asFlux(arrayOf("a", "b"))

        StepVerifier
            .create(result)
            .expectSubscription()
            .expectNext("a")
            .expectNext("b")
            .verifyComplete()
    }

    @Test
    fun `should return flux of integers with count`() {
        val reactiveService = ReactiveService()

        val result = reactiveService.asFlux(arrayOf(1,2,3))

        StepVerifier
            .create(result)
            .expectSubscription()
            .expectNextCount(3)
            .verifyComplete()
    }

    @Test
    fun `should return flux of given integers`() {
        val reactiveService = ReactiveService()

        val result = reactiveService.asFlux(arrayOf(1,2,3))

        StepVerifier
            .create(result)
            .expectSubscription()
            .expectNext(1)
            .expectNext(2)
            .expectNext(3)
            .verifyComplete()
    }

    @Test
    fun `should return mono of string`() {
        val reactiveService = ReactiveService()

        val result = reactiveService.asMono("abc")

        StepVerifier
            .create(result)
            .expectSubscription()
            .assertNext { it shouldBe "abc" }
            .verifyComplete()
    }

    @Test
    fun `should return mono of error with message`() {
        val reactiveService = ReactiveService()

        val result = reactiveService.monoError("my custom error")

        StepVerifier
            .create(result)
            .expectSubscription()
            .expectErrorMessage("my custom error")
            .verify()
    }
}