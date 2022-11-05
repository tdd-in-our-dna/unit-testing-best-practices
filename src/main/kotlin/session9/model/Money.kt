package session9.model

import java.math.BigDecimal
import java.math.RoundingMode

data class Money(val amount: Double, val currency: Currency) {
    fun toUsDollars(): Money {
        val amount = BigDecimal(amount.div(83)).setScale(2, RoundingMode.HALF_UP)
        return Money(amount.toDouble(), Currency.USD)
    }
}
