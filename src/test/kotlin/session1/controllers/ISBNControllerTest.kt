package session1.controllers

import io.mockk.*
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import session1.controllers.ISBNController
import session1.models.ISBNValidity
import session1.services.ISBNService

class ISBNControllerTest {

    // Step 1
//    @Test
//    internal fun `should return success response for valid isbn`() {
//        val isbnController = ISBNController()
//        val isbn = "1670927059"
//        val expectedResponse = ISBNValidity(isbn, true)
//
//        val response = isbnController.validateISBN(isbn)
//
//        response `should be equal to` expectedResponse


//        val isbnController = ISBNController()
//        val isbn = "1670927059"
//        val expectedResponse = ISBNValidity(isbn, true)
//
//        val response = isbnController.validateISBN(isbn)
//
//        response `should be equal to` expectedResponse
//    }

    // Step 2
    @Test
    internal fun `should return success response for valid isbn`() {
        val isbnService = mockk<ISBNService>()
        val isbnController = ISBNController(isbnService)
        val isbn = "1670927059"
        val expectedResponse = ISBNValidity(isbn, true)

        every { isbnService.validateISBN(isbn) } returns expectedResponse

        val response = isbnController.validateISBN(isbn)

        response `should be equal to` expectedResponse

        verify { isbnService.validateISBN(isbn) }
    }

    @Test
    internal fun `should return failure response for invalid isbn`() {
        val isbnService = mockk<ISBNService>()
        val isbnController = ISBNController(isbnService)
        val invalidIsbn = "1670927058"
        val expectedResponse = ISBNValidity(invalidIsbn, false)

        every { isbnService.validateISBN(invalidIsbn) } returns expectedResponse

        val response = isbnController.validateISBN(invalidIsbn)

        response `should be equal to` expectedResponse

        verify { isbnService.validateISBN(invalidIsbn) }
    }

}