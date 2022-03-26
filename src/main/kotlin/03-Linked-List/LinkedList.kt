package `03-Linked-List`

import java.util.function.Predicate

/*
`03-Linked-List`.LinkedList

LinkedList는 노드들이 연결된 거다.
head 노드
tail 노드 가 있고
size ( 전체 노드의 길이 ) 가 있다.
이 3개의 정보가 어떤지에 따라 상태가 달라진다.

head , tail 둘다 null인 상태 => 아무것도 없다. ( size == 0 )
head = not null, tail = null => 한개 있다. ( size == 1 )
head, tail 둘다 not null인 상태 => 여러개 있다. ( size == n )


 */

// 모든 링크드 리스트 객체는 처음에 null null 0 로 시작한다.
class LinkedList<T : Any>
    : Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T> {

    // basic data for linked list
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    override var size = 0
        private set

    // Any Class Override
    override fun toString(): String {
        if (isEmpty()) {
            return "EmptyList"
        } else {
            return head.toString()
        }
    }

    // Iterable / Mutable Iterable Interface Override function
    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }

    // Collection Interface Override function
    override fun isEmpty(): Boolean = size == 0

    override fun contains(element: T): Boolean {
        for (item in this) {
            if (item == element) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements) {
            if (!contains(searched)) return false
        }
        return true
    }

    // MutableCollection Interface Override function
    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            append(element)
        }
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if(item == element) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements) {
            result = remove(item) || result
        }
        return result
    }

    override fun removeIf(filter: Predicate<in T>): Boolean {
        return super.removeIf(filter)
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result =false
        val iterator = this.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if(!elements.contains(item)){
                iterator.remove()
                result = true
            }
        }
        return result
    }

    // functions for updating data
    fun push(value: T): LinkedList<T> {
        return apply {
            head = Node(value = value, next = head)
            if (tail == null) {
                tail = head
            }
            size++
        }
    }

    // size == 0 인지 판단후 0 이면 push 사용하고 아니면 append
    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }
        val newNode = Node(value = value, next = null)
        tail!!.next = newNode

        tail = newNode
        size++
    }

    // function for searching data
    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        if (isEmpty()) return null
        else {
            while (currentIndex < index) {
                currentNode = currentNode?.next
                currentIndex++
            }
            return currentNode
        }
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        if (afterNode == tail) {
            append(value)
            return requireNotNull(tail)
        }

        val newNode = Node(value = value, next = afterNode.next)

        afterNode.next = newNode
        size++
        return newNode
    }

    // functions for deleting data
    fun pop(): T? {
        if (isEmpty()) return null
        else {
            val poppedValue = head!!.value
            head = head!!.next
            size--
            if (isEmpty()) {
                tail = null
            }

            return poppedValue
        }
    }

    fun removeLast(): T? {
        val head = head ?: return null
        if (head.next == null) return pop()
        size--

        var prev = head
        var current = head

        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        // 이거 두개만 하고 싶은데, prev를 찾아야 해서 위의 과정을 거쳐야 함
        prev.next = null
        tail = prev
        return current.value
    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value

        if (node.next == tail) {
            tail = node
        }

        if (node.next != null) {
            size--
        }

        node.next = node.next?.next
        return result
    }

}