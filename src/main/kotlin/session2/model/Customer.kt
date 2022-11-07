package session2.model

data class Customer(val mobileNumber: String, val name: String, val address: String, val age: Int) {
    fun toCustomerDomainModel(): CustomerDomainModel {
        return CustomerDomainModel(mobileNumber.toInt(), name, address, age, true)
    }

}
