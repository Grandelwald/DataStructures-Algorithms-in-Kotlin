package `03-Linked-List`/*
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
class LinkedList<T : Any> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean = size == 0

    override fun toString(): String {
        if (isEmpty()) {
            return "EmptyList"
        } else {
            return head.toString()
        }
    }
//    push().ver1
//    fun push(value : T) {
//        head = `03-Linked-List`.Node(value = value, next = head)
//        if(tail == null){
//            tail = head
//        }
//        size++
//    }

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

    // Insert Operations
    /*
    1. 리스트에서 특별한 노드를 찾는다.
    2. 그 노드 뒤에 새로운 노드를 삽입한다.
     */
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

    fun removeAfter(node: Node<T>):T? {
        val result = node.next?.value

        if(node.next == tail) {
            tail = node
        }

        if(node.next != null) {
            size--
        }

        node.next = node.next?.next
        return result
    }

}