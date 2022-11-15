package session9.assertions

import java.math.BigDecimal
import kotlin.test.assertEquals
import session9.model.Currency
import session9.model.Money

fun assertUSD(
    expectedAmount: Double,
    actualAmount: Double,
) = assertEquals(Money(BigDecimal(expectedAmount), Currency.USD), Money(BigDecimal(actualAmount), Currency.USD))

fun assertConvertedUSD(expected: Double, actual: BigDecimal) = assertUSD(expected, actual.toDouble())
