package session9.model

import kotlin.test.assertEquals


fun assertMoney(
    expectedAmount: Double,
    expectedCurrency: Currency,
    actualAmount: Double,
    actualCurrency: Currency
) {
   assertEquals(Money(expectedAmount, expectedCurrency), Money(actualAmount, actualCurrency))
}