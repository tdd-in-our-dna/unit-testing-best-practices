package session9.controller

import io.kotlintest.shouldBe
import java.time.Clock
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import org.junit.jupiter.api.Test
import session9.model.Transaction
import session9.model.TransactionType
import session9.model.TransactionType.DEBIT

class TransactionControllerTestV2 {

    @Test
    fun `should create transaction on withdrawal`() {
        val currentBalance = 100
        val amountToWithDraw = 10
        val now = 1668516499L
        val clock = Clock.fixed(Instant.ofEpochMilli(now), ZoneId.systemDefault())

        val transactionController = TransactionControllerV2(clock)

        val transaction = transactionController.withdraw(currentBalance, amountToWithDraw)

        transaction shouldBe Transaction(
            10,
            90,
            DEBIT,
            LocalDate.of(1970, 1, 20)
        )
    }

    @Test
    fun `should create transaction on withdrawal on low balance`() {
        val currentBalance = 10
        val amountToWithDraw = 9
        val now = 1668516499L
        val clock = Clock.fixed(Instant.ofEpochMilli(now), ZoneId.systemDefault())

        val transactionController = TransactionControllerV2(clock)

        val transaction = transactionController.withdraw(currentBalance, amountToWithDraw)

        transaction shouldBe Transaction(
            9,
            1,
            DEBIT,
            LocalDate.of(1970, 1, 20)
        )
    }

    @Test
    fun `should create transaction on withdrawal on large balance`() {
        val currentBalance = 1000000
        val amountToWithDraw = 900000
        val now = 1668516499L
        val clock = Clock.fixed(Instant.ofEpochMilli(now), ZoneId.systemDefault())

        val transactionController = TransactionControllerV2(clock)

        val transaction = transactionController.withdraw(currentBalance, amountToWithDraw)

        transaction shouldBe Transaction(
            900000,
            100000,
            DEBIT,
            LocalDate.of(1970, 1, 20)
        )
    }

}