package `04-Stack`

interface Stack<T : Any> {
    val count: Int
        get
    val isEmpty: Boolean
        get() = count == 0

    fun push(element: T)
    fun pop(): T?
    fun peek(): T?

}

fun <T:Any> stackOf(vararg elements:T):Stack<T> {
    return StackImpl.create(elements.asList())
}