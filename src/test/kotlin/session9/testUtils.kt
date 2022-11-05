package session9

import kotlin.test.assertEquals
import session9.model.Currency
import session9.model.Money


fun assertMoney(
    expectedAmount: Double,
    expectedCurrency: Currency,
    actualAmount: Double,
    actualCurrency: Currency
) {
   assertEquals(Money(expectedAmount, expectedCurrency), Money(actualAmount, actualCurrency))
}