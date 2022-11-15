package session9.controller

import io.kotlintest.shouldBe
import java.time.Clock
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset
import org.junit.jupiter.api.Test
import session9.model.Transaction
import session9.model.TransactionType.DEBIT

class TransactionControllerTestV2 {

    @Test
    fun `should create transaction on withdrawal`() {
        val currentBalance = 100
        val amountToWithDraw = 10
        val clock = Clock.fixed(Instant.parse("2022-11-15T00:00:00.00Z"), ZoneOffset.UTC)

        val transactionController = TransactionControllerV2(clock)

        val transaction = transactionController.withdraw(currentBalance, amountToWithDraw)

        transaction shouldBe Transaction(
            10,
            90,
            DEBIT,
            LocalDate.of(2022, 11, 15)
        )
    }

    @Test
    fun `should create transaction on withdrawal on low balance`() {
        val currentBalance = 10
        val amountToWithDraw = 9
        val clock = Clock.fixed(Instant.parse("2022-11-15T00:00:00.00Z"), ZoneOffset.UTC)

        val transactionController = TransactionControllerV2(clock)

        val transaction = transactionController.withdraw(currentBalance, amountToWithDraw)

        transaction shouldBe Transaction(
            9,
            1,
            DEBIT,
            LocalDate.of(2022, 11, 15)
        )
    }

    @Test
    fun `should create transaction on withdrawal on large balance`() {
        val currentBalance = 1000000
        val amountToWithDraw = 900000
        val clock = Clock.fixed(Instant.parse("2022-11-15T00:00:00.00Z"), ZoneOffset.UTC)

        val transactionController = TransactionControllerV2(clock)

        val transaction = transactionController.withdraw(currentBalance, amountToWithDraw)

        transaction shouldBe Transaction(
            900000,
            100000,
            DEBIT,
            LocalDate.of(2022, 11, 15)
        )
    }

}