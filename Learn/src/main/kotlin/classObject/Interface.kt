package classObject

interface A {
    fun foo() { print("A") }
    fun bar()
}

interface B {
    fun foo() { print("B") }
    fun bar() { print("BarB")}
}

class C:A {
    override fun bar() {
        print("BarA")
    }
}

class D: A,B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}

fun main() {
    val c = C()

    c.foo()
    c.bar()

    val d = D()

    d.foo()
}