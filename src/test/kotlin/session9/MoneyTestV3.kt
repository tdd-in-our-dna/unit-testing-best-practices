package session9

import org.junit.jupiter.api.Test
import session9.model.Currency.INR
import session9.model.Currency.USD
import session9.model.Money

class MoneyTestV3 {

    @Test
    fun `should convert of Money from INR to USD`() {
        val indianRupee = Money(1200.00, INR)
        val usDollars = indianRupee.toUsDollars()
        assertMoney(14.46, USD, usDollars.amount, usDollars.currency)
    }

}