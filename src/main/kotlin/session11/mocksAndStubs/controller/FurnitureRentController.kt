package session11.mocksAndStubs.controller

import org.springframework.http.HttpStatus.OK
import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import session11.mocksAndStubs.exception.FurnitureUnavailableException
import session11.mocksAndStubs.service.FurnitureRentService

@RestController
class FurnitureRentController(
    private val furnitureRentService: FurnitureRentService
) {
    @PostMapping("/furniture/{id}/rent")
    fun rent(@PathVariable("id") furnitureId: Int): ResponseEntity<Any> {
        return try {
            furnitureRentService.rent(furnitureId)
            ResponseEntity("Furniture with id- $furnitureId rented successfully!", OK)
        } catch (FurnitureUnavailableException: FurnitureUnavailableException) {
            ResponseEntity("Furniture with id- $furnitureId unavailable for rent!", UNPROCESSABLE_ENTITY)
        }
    }
}