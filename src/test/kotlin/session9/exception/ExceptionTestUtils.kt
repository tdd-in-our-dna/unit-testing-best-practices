package session9.exception

import io.kotlintest.assertSoftly
import io.kotlintest.fail
import io.kotlintest.matchers.throwable.shouldHaveMessage
import io.kotlintest.shouldBe

fun <T> assertException(clazz: Class<T>, message: String, block: () -> Unit) {
    var wasExceptionThrown = false
    try {
        block()
    } catch (exception: Exception) {
        assertSoftly {
            wasExceptionThrown = true
            exception.javaClass shouldBe clazz
            exception shouldHaveMessage message
        }
    }
    if (!wasExceptionThrown) {
        fail("Expected $clazz but none was thrown")
    }
}

fun assertMyException(message: String, block: (() -> Unit)) {
    assertException(MyException::class.java, message, block)
}