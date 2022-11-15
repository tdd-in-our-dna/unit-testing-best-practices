package session9.controller

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import session9.assertions.debitTxn
import session9.fixedClock
import java.time.LocalDate.of

class TransactionControllerTestV3 {

    @Test
    fun `should create debit transaction on withdrawal on same date`() { //test that cares about date
        val fixedClock = fixedClock(of(2022, 11, 15))
        val transactionController = TransactionControllerV2(fixedClock)

        val transaction = transactionController.withdraw(100, 10)

        transaction shouldBe debitTxn(10, 90, of(2022, 11, 15))
    }

    @Test
    fun `should create debit transaction on withdrawal on low balance`() { //test that does not care about date
        val transactionController = TransactionControllerV2(fixedClock())

        val transaction = transactionController.withdraw(10, 9)

        transaction shouldBe debitTxn(9, 1)
    }

    @Test
    fun `should create debit transaction on withdrawal on large balance`() { //test that does not care about date
        val transactionController = TransactionControllerV2(fixedClock())

        val transaction = transactionController.withdraw(1000000, 900000)

        transaction shouldBe debitTxn(900000, 100000)
    }

}