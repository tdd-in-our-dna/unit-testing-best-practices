package session9.model

import java.math.BigDecimal
import kotlin.test.assertEquals

fun assertUSD(
    expectedAmount: Double,
    actualAmount: Double,
) = assertEquals(Money(BigDecimal(expectedAmount), Currency.USD), Money(BigDecimal(actualAmount), Currency.USD))

fun assertConvertedUSD(expected: Double, actual: BigDecimal) = assertUSD(expected, actual.toDouble())
