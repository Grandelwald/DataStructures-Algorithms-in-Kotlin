package `03-Linked-List`

class LinkedListIterator<T : Any>(private val list: LinkedList<T>) : Iterator<T> {
    private var index = 0
    private var lastNode: Node<T>? = null

    override fun next(): T {
        // 노드의 값을 순서대로 읽는다.
        if (index >= list.size) throw IndexOutOfBoundsException()

        lastNode = if( index == 0) {
            list.nodeAt(0)
        }else{
            lastNode?.next
        }

        index++
        return lastNode!!.value
    }

    override fun hasNext(): Boolean {
        // 너의 Iterable이 여전히 읽을 값을 가지고 있는지 Boolean 값을 반환한다.
        return index < list.size
    }
}