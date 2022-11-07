package session2.controller

import session2.model.Customer
import session2.service.CustomerService
import session2.validator.CustomerValidator

class CustomerController(
    private val customerValidator: CustomerValidator,
    private val customerService: CustomerService,
    private val maxAddressSize: Int

) {
    fun save(customer: Customer): String {
        val isCustomerValid = customerValidator.validate(customer, maxAddressSize)
        return if (isCustomerValid) {
            if (customerService.save(customer, true)) {
                return "OK"
            } else {
                "INTERNAL_SERVER_ERROR"
            }
        } else "BAD_REQUEST"
    }
}
