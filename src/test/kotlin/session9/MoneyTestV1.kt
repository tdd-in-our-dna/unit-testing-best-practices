package session9

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test
import session9.model.Currency
import session9.model.Currency.INR
import session9.model.Money

class MoneyTestV1 {

    @Test
    fun `should convert Money from INR to USD`() {
        val indianRupee = Money(1200.00, INR)
        val usDollars = indianRupee.toUsDollars()
        assertEquals(Money(14.46, Currency.USD), usDollars)
    }

}