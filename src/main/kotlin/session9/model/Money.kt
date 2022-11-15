package session9.model

import java.math.BigDecimal
import java.math.RoundingMode

data class Money(val amount: BigDecimal, val currency: Currency) {

    fun toUsDollars(): Money {
        val rateINRPerDollar = BigDecimal(83)
        val amount = amount.div(rateINRPerDollar)
            .setScale(2, RoundingMode.HALF_UP)
        return Money(amount, Currency.USD)
    }

}
