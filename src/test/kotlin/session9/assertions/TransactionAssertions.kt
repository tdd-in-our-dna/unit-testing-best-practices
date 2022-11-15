package session9.assertions

import session9.EPOCH_DAY
import session9.model.Transaction
import session9.model.TransactionType.DEBIT
import java.time.LocalDate

fun debitTxn(
    amount: Int,
    remainingBalance: Int,
    dateTime: LocalDate = EPOCH_DAY
) = Transaction(amount, remainingBalance, DEBIT, dateTime)