package session9.exception

import io.kotlintest.assertSoftly
import io.kotlintest.matchers.throwable.shouldHaveMessage
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import org.junit.jupiter.api.Test

class MyClassTestV1 {

    @Test
    fun `should throw my exception for operation1`() {
        val myClass = MyClass()

        try {
            myClass.operation1()
        } catch (exception: MyException) {
            exception shouldHaveMessage "operation1 failed"
        }

    }

    @Test
    fun `should throw my exception for operation2`() {
        val myClass = MyClass()

        try {
            myClass.operation2()
        } catch (exception: Exception) {
            assertSoftly {
                exception.javaClass shouldBe MyException::javaClass
                exception.message shouldBe "operation2 failed"
            }
        }
    }

    @Test
    fun `should throw my exception for operation3`() {
        val myClass = MyClass()

        val exception = shouldThrow<MyException> { myClass.operation3() }
        exception shouldHaveMessage "operation3 failed"
    }

    @Test
    fun `should throw my exception for operation4`() {
        val myClass = MyClass()

        shouldThrow<MyException> { myClass.operation4() }
    }
}