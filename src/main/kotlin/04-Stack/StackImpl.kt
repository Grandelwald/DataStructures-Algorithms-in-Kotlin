package `04-Stack`

class StackImpl<T:Any> : Stack<T> {
    private val storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override fun toString(): String = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if(isEmpty) return null
        return storage.removeAt( count - 1)
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    companion object{
        fun <T:Any> create(items : Iterable<T>) : Stack<T> {
            val stack = StackImpl<T>()
            for (item in items) {
                stack.push(item)
            }
            return stack
        }
    }
}