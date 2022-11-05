package session9

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test
import session9.model.Currency.INR
import session9.model.Currency.USD
import session9.model.Money

class MoneyTestV2 {

    @Test
    fun `should convert the amount of Money from INR to USD`() {
        val indianRupee = Money(1200.00, INR)
        val usDollars = indianRupee.toUsDollars()
        assertEquals(14.46, usDollars.amount)
    }

    @Test
    fun `should convert the currency Money from INR to USD`() {
        val indianRupee = Money(1200.00, INR)
        val usDollars = indianRupee.toUsDollars()
        assertEquals(USD, usDollars.currency)
    }

}