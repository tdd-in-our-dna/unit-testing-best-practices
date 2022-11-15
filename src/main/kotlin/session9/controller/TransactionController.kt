package session9.controller

import java.time.Clock
import java.time.LocalDate
import java.time.ZoneOffset
import session9.model.Transaction
import session9.model.TransactionType

class TransactionController(private val clock: Clock) {

    fun withdraw(currentBalance: Int, amountToWithDraw: Int): Transaction {
        val remainingAmount = currentBalance - amountToWithDraw
        return Transaction(
            amountToWithDraw,
            remainingAmount,
            TransactionType.DEBIT,
            LocalDate.ofInstant(clock.instant(), ZoneOffset.UTC)
        )
    }
}
