package session1.controllers

import session1.models.ISBNValidity
import session1.services.ISBNService

// step 1
//class ISBNController() {
//    fun validateISBN(isbn: String): ISBNValidity {
//        return ISBNValidity(isbn, true)
//    }
//}


// step 2
class ISBNController(private val isbnService: ISBNService) {
    fun validateISBN(isbn: String): ISBNValidity {
        return isbnService.validateISBN(isbn)
    }
}


//class ISBNController {
//    fun validateISBN(isbn: String) {
//        TODO("Not yet implemented")
//    }
//
//}
