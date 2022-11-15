package session9.exception

import org.junit.jupiter.api.Test
import session9.assertions.assertException
import session9.assertions.assertMyException

class MyClassTestV2 {

    @Test
    fun `should throw my exception for operation1`() {
        val myClass = MyClass()

        val block = { myClass.operation1() }

        assertException(MyException::class.java, "operation1 failed", block)
    }

    @Test
    fun `should throw my exception for operation2`() {
        val myClass = MyClass()

        val block = { myClass.operation2() }

        assertException(MyException::class.java, "operation2 failed", block)
    }

    @Test
    fun `should throw my exception for operation3`() {
        val myClass = MyClass()

        val block = { myClass.operation3() }

        assertMyException("operation3 failed", block)
    }

    @Test
    fun `should throw my exception for operation4`() {
        val myClass = MyClass()

        val block = { myClass.operation4() }

        assertMyException("operation4 failed", block)
    }

}