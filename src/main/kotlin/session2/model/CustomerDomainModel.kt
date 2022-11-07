package session2.model

data class CustomerDomainModel(
    val mobileNumber: Int,
    val name: String,
    val address: String,
    val age: Int,
    val isSeniorCitizen: Boolean
)
