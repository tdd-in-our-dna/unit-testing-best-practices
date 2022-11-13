package session9.model

import java.math.BigDecimal
import org.junit.jupiter.api.Test
import session9.model.Currency.INR

class MoneyTestV2 {

    @Test
    fun `should convert Money from INR to USD`() {
        val indianRupee = Money(BigDecimal(1200.00), INR)
        val usDollars = indianRupee.toUsDollars()
        assertUSD(14.00, usDollars.amount.toDouble())
    }

    @Test
    fun `should convert small amount from INR to USD `() {
        val indianRupee = Money(BigDecimal(200.00), INR)
        val usDollars = indianRupee.toUsDollars()
        assertUSD(2.00, usDollars.amount.toDouble())
    }

    @Test
    fun `should convert large amount from INR to USD `() {
        val indianRupee = Money(BigDecimal(10000.00), INR)
        val usDollars = indianRupee.toUsDollars()
        assertUSD(120.00, usDollars.amount.toDouble())
    }
}
