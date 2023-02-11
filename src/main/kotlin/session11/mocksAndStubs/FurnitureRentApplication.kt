package session11.mocksAndStubs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FurnitureRentApplication

fun main(args: Array<String>) {
    runApplication<FurnitureRentApplication>(*args)
}