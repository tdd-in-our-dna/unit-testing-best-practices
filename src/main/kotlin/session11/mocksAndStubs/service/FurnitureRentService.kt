package session11.mocksAndStubs.service

import org.springframework.stereotype.Service
import session11.mocksAndStubs.exception.FurnitureUnavailableException
import session11.mocksAndStubs.repository.FurnitureRepository

@Service
class FurnitureRentService(
    private val furnitureRepository: FurnitureRepository,
    private val mailService: MailService
) {
    fun rent(furnitureId: Int) {
        if (furnitureRepository.isAvailable(furnitureId)) {
            furnitureRepository.reserve(furnitureId)
            println(
                mailService.send(
                    "[Furniture id- ${furnitureId}] ${furnitureRepository.getById(furnitureId).title} is reserved!"
                )
            )
        } else {
            throw FurnitureUnavailableException("Furniture with id: $furnitureId is unavailable")
        }
    }
}