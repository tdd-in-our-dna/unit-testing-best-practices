package session9.controller

import io.kotlintest.shouldBe
import java.time.Clock
import java.time.LocalDate
import org.junit.jupiter.api.Test
import session9.model.Transaction
import session9.model.TransactionType

class TransactionControllerTestV1 {

    @Test
    fun `should create transaction on withdrawal`() {
        val currentBalance = 100
        val transactionController = TransactionControllerV1()
        val amountToWithDraw = 10
        val transaction = transactionController.withdraw(currentBalance, amountToWithDraw)
        transaction shouldBe Transaction(
            10,
            90,
            TransactionType.DEBIT,
            LocalDate.of(2022,11,15)
        )
    }

    @Test
    fun `should create transaction on withdrawal on low balance`() {
        val currentBalance = 10
        val transactionController = TransactionControllerV1()
        val amountToWithDraw = 9
        val transaction = transactionController.withdraw(currentBalance, amountToWithDraw)
        transaction shouldBe Transaction(
            9,
            1,
            TransactionType.DEBIT,
            LocalDate.of(2022,11,15)
        )
    }

    @Test
    fun `should create transaction on withdrawal on large balance`() {
        val currentBalance = 1000000
        val transactionController = TransactionControllerV1()
        val amountToWithDraw = 900000
        val transaction = transactionController.withdraw(currentBalance, amountToWithDraw)
        transaction shouldBe Transaction(
            900000,
            100000,
            TransactionType.DEBIT,
            LocalDate.of(2022,11,15)
        )
    }

}