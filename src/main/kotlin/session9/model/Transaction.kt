package session9.model

import java.time.LocalDate

data class Transaction(
    val amount: Int,
    val remainingBalance: Int,
    val transactionType: TransactionType,
    val dateTime: LocalDate
)