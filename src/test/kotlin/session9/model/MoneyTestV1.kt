package session9.model

import io.kotlintest.shouldBe
import java.math.BigDecimal
import org.junit.jupiter.api.Test
import session9.model.Currency.INR
import session9.model.Currency.USD

class MoneyTestV1 {

    @Test
    fun `should convert Money from INR to USD`() {
        val indianRupee = Money(BigDecimal(1200.00), INR)
        val usDollars = indianRupee.toUsDollars()
        usDollars.amount.toDouble() shouldBe 14.00
        usDollars.currency shouldBe USD
    }

    @Test
    fun `should convert small amount from INR to USD `() {
        val indianRupee = Money(BigDecimal(200.00), INR)
        val usDollars = indianRupee.toUsDollars()
        usDollars.amount.toDouble() shouldBe 2.00
        usDollars.currency shouldBe USD
    }

    @Test
    fun `should convert large amount from INR to USD `() {
        val indianRupee = Money(BigDecimal(10000.00), INR)
        val usDollars = indianRupee.toUsDollars()
        usDollars.amount.toDouble() shouldBe 120.00
        usDollars.currency shouldBe USD
    }
}
