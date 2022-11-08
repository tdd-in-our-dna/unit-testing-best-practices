package session9.reactive

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class ReactiveService {

    fun asFlux(strings: Array<String>): Flux<String> {
        return Flux.fromArray(strings)
    }

    fun asFlux(integers: Array<Int>): Flux<Int> {
        return Flux.fromArray(integers)
    }

    fun asMono(string: String): Mono<String> {
        return Mono.just(string)
    }

    fun monoError(message: String): Mono<Any> {
        return Mono.error(RuntimeException(message))
    }
}