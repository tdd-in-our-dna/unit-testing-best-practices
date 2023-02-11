package session11.mocksAndStubs.service

import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import session11.mocksAndStubs.domain.Furniture
import session11.mocksAndStubs.exception.FurnitureUnavailableException
import session11.mocksAndStubs.repository.FurnitureRepository

class FurnitureRentServiceTest {
    @Test
    fun `should reserve furniture and send mail when furniture is available`() {
        val furnitureRepository = mockk<FurnitureRepository>()
        val mailService = mockk<MailService>()
        val furnitureRentService = FurnitureRentService(furnitureRepository, mailService)
        val furnitureId = 5

        every { furnitureRepository.isAvailable(any()) } returns true
        every { furnitureRepository.reserve(any()) } just runs
        every { furnitureRepository.getById(any()) } returns Furniture(5, "Steel Shelf", 1805.25, true)
        every { mailService.send(any()) } returns "Mail Sent Successfully with subject- [Furniture id- 5] Steel Shelf is reserved!"

        // State verification - Helps test state
        assertDoesNotThrow {
            furnitureRentService.rent(furnitureId)
        }

        // Behaviour verification - Don't do this
//        verify {
//            furnitureRepository.reserve(furnitureId)
//            mailService.send(Message(Furniture(5, "Steel Shelf", 1805.25, true)))
//        }
    }

    @Test
    fun `should throw FurnitureUnavailableException when furniture is unavailable`() {
        val furnitureRepository = mockk<FurnitureRepository>()
        val mailService = mockk<MailService>()
        val furnitureRentService = FurnitureRentService(furnitureRepository, mailService)
        val furnitureId = 5

        every { furnitureRepository.isAvailable(any()) } returns false

        // State verification - Helps test state
        assertThrows<FurnitureUnavailableException> {
            furnitureRentService.rent(furnitureId)
        }

        // Behaviour verification - Don't do this
//        verify(exactly = 0) {
//            furnitureRepository.reserve(furnitureId)
//            mailService.send(Message(Furniture(5, "Steel Shelf", 1805.25, true)))
//        }
    }
}