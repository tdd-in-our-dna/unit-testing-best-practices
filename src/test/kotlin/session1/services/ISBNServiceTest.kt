package session1.services

import session1.models.ISBNValidity
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import session1.services.ISBNService

class ISBNServiceTest {

    // Step 3
    @Test
    fun `should check for valid isbn`() {
        val isbnService = ISBNService()
        val isbn = "1670927059"
        val expectedResponse = ISBNValidity(isbn, true)

        val response = isbnService.validateISBN(isbn)

        response `should be equal to` expectedResponse
    }

    // step 4
    @Test
    fun `should check for invalid isbn`() {
        val isbnService = ISBNService()
        val isbn = "1670927058"
        val expectedResponse = ISBNValidity(isbn, false)

        val response = isbnService.validateISBN(isbn)

        response `should be equal to` expectedResponse
    }


    // step 6 - new requirement - inform user if isbn length is not 10
    @Test
    fun `should throw error if length of isbn is not 10`() {
        val isbnService = ISBNService()
        val isbn = "16709270591122"

        assertThrows<Exception> {
            isbnService.validateISBN(isbn)
        }
    }

    // Why Red first ??
    // step 7 - new requirement - inform user with error if isbn is non-numeric
    @Test
    fun `should throw error if isbn is non numeric`() {
        val isbnService = ISBNService()
        val isbn = "hellloworld"

        assertThrows<Exception> {
            isbnService.validateISBN(isbn)
        }
    }
}