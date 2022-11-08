package session9.exception

class MyClass {

    fun operation1() {
        val x = 1/0
    }

    fun operation2() {
        println("does nothing")
    }

    fun operation3() {
        throw RuntimeException()
    }

    fun operation4() {
        throw MyException("WRONG message")
    }
}