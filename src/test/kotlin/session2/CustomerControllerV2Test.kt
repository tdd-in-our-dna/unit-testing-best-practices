package session2

import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import session2.controller.CustomerController
import session2.model.Customer
import session2.service.CustomerService
import session2.validator.CustomerValidator

class CustomerControllerV2Test {
    //state verification done instead of behaviour verification
    @Test
    fun `should save a customer when age is valid`() {
        val customerRequest = Customer("1", "Mark", "123,8th Cross Road", 10)

        val customerValidator = mockk<CustomerValidator>()
        val customerService = mockk<CustomerService>()
        val customerController = CustomerController(customerValidator, customerService, 20)

        every { customerValidator.validate(any(), any()) } returns true
        every { customerService.save(any(), any()) } returns true

        val response = customerController.save(customerRequest)
        response shouldBe "OK"

    }
    //tiny universe principle followed, every test is isolated
    @Test
    fun `should return bad request when customer age is invalid`() {
        val customerRequest = Customer("1", "Mark", "123,8th Cross Road", 10)

        val customerValidator = mockk<CustomerValidator>()
        val customerService = mockk<CustomerService>()
        val customerController = CustomerController(customerValidator, customerService, 20)

        every { customerValidator.validate(any(), any()) } returns false

        val response = customerController.save(customerRequest)

        response shouldBe "BAD_REQUEST"

    }

    @Test
    fun `should return internalServer error if customer is not saved successfully`() {
        val customerRequest = Customer("1", "Mark", "123,8th Cross Road", 10)

        val customerValidator = mockk<CustomerValidator>()
        val customerService = mockk<CustomerService>()
        val customerController = CustomerController(customerValidator, customerService, 10)

        every { customerValidator.validate(any(), any()) } returns true
        every { customerService.save(any(), any()) } returns false

        val response = customerController.save(customerRequest)
        response shouldBe "INTERNAL_SERVER_ERROR"
    }
    // state verification used instead of behaviour/implementation details
    @Test
    fun `should return bad request if customer's address length is bigger standard address size`() {
        val customerValidator = mockk<CustomerValidator>()
        val customerService = mockk<CustomerService>()
        val customerController = CustomerController(customerValidator, customerService, 10)

        every { customerValidator.validate(any(), any()) } returns false

        val customerRequest = Customer("12344", "Sara", "B-500, abc apartments", 20)
        val response = customerController.save(customerRequest)

        response shouldBe "BAD_REQUEST"

    }
}
