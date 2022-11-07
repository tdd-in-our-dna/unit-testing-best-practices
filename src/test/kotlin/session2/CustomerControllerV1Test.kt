package session2

import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifySequence
import org.junit.jupiter.api.Test
import session2.controller.CustomerController
import session2.model.Customer
import session2.service.CustomerService
import session2.validator.CustomerValidator

class CustomerControllerV1Test {
    private val customerValidator = mockk<CustomerValidator>()
    private val customerService = mockk<CustomerService>()
    private val maxAddressSize = 50
    private val customerController = CustomerController(customerValidator, customerService, maxAddressSize)

    //tiny universe principle violated
    @Test
    fun `should save a customer when age is valid`() {

        val customerRequest = Customer("1", "Mark", "123,8th Cross Road", 10)

        every { customerValidator.validate(any(), any()) } returns true
        every { customerService.save(any(), any()) } returns true

        val response = customerController.save(customerRequest)

        response shouldBe "OK"
        verifySequence {
            customerValidator.validate(customerRequest, 50, )
            customerService.save(customerRequest, true)
        }
    }

    //behaviour verification used
    @Test
    fun `should return bad request when customer age is invalid`() {
        val customerRequest = Customer("1", "Mark", "123,8th Cross Road", 10)
        every { customerValidator.validate(any(), any()) } returns false

        val response = customerController.save(customerRequest)

        response shouldBe "BAD_REQUEST"
        verify(exactly = 0) {
            customerService.save(customerRequest, false)
        }
    }

    @Test
    fun `should throw internal Server error if customer is not saved successfully`() {
        val customerRequest = Customer("1", "Mark", "123,8th Cross Road", 90)

        every { customerValidator.validate(any(), any()) } returns true
        every { customerService.save(any(), any()) } returns false

        val response = customerController.save(customerRequest)
        response shouldBe "INTERNAL_SERVER_ERROR"
        verifySequence {
            customerService.save(customerRequest, true)
        }
    }

}
