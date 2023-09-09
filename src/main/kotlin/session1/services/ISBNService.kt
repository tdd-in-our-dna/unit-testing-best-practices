package session1.services

import session1.models.ISBNValidity

// step 2
//class ISBNService {
//    fun validateISBN(isbn: String) : ISBNValidity {
//        TODO("Not yet implemented")
//    }
//}

// step 3
//class ISBNService {
//    fun validateISBN(isbn: String) : ISBNValidity {
//        return ISBNValidity(isbn, true)
//    }
//}

// step 4
//class ISBNService {
//    fun validateISBN(isbn: String) : ISBNValidity {
//        var total = 0
//        for (i in 0..9) {
//             total += isbn[i].digitToInt() * (10 - i)
//        }
//
//        return if(total % 11 == 0) {
//            ISBNValidity(isbn, true)
//        } else {
//            ISBNValidity(isbn, false)
//        }
//    }
//}


// step 5 - refactor - check if tests are still passing
//class ISBNService {
//    fun validateISBN(isbn: String) : ISBNValidity {
//        var total = 0
//        for (i in 0..9) {
//            total += isbn[i].digitToInt() * (10 - i)
//        }
//
//        return ISBNValidity(isbn, total % 11 == 0)
//    }
//}

// step 6
//class ISBNService {
//    fun validateISBN(isbn: String) : ISBNValidity {
//        if (isbn.length != 10) throw BadRequestException("")
//
//        var total = 0
//        for (i in 0..9) {
//            total += (10 - i) * isbn[i].digitToInt()
//        }
//
//        return ISBNValidity(isbn, total % 11 == 0)
//    }
//}

// step 7
class ISBNService {
    fun validateISBN(isbn: String) : ISBNValidity {
        if (isbn.length != 10) throw Exception("")

        var total = 0
        for (i in 0..9) {
            try {
                total += (10 - i) * isbn[i].digitToInt()
            } catch (e: IllegalArgumentException) {
                throw Exception("")
            }
        }

        return ISBNValidity(isbn, total % 11 == 0)
    }
}