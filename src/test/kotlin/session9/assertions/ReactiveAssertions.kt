package session9.assertions

import io.kotlintest.assertSoftly
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

fun <T> Flux<T>.assertNextCount(count: Long) {
    StepVerifier
        .create(this)
        .expectSubscription()
        .expectNextCount(count)
        .verifyComplete()
}

fun <T> Flux<T>.assertNextElements(vararg elements: T) {

    assertSoftly {
        val step = StepVerifier
            .create(this)
            .expectSubscription()

        for (element in elements) {
            step.expectNext(element)
        }

        step.verifyComplete()
    }
}

fun <T> Mono<T>.assertNextElement(element: T) {
    StepVerifier
        .create(this)
        .expectSubscription().expectNext(element)
        .verifyComplete()
}

fun <T> Mono<T>.assertErrorMessage(message: String) {
    StepVerifier
        .create(this)
        .expectSubscription()
        .expectErrorMessage(message)
        .verify()
}

fun <T> Flux<T>.assertNext(vararg assertions: (t: T) -> Unit) {
    assertSoftly {
        val step = StepVerifier
            .create(this)
            .expectSubscription()

        for (assertion in assertions) {
            step.assertNext(assertion)
        }

        step.verifyComplete()
    }
}
