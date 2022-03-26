import sun.awt.image.ImageWatched.Link

fun main(args: Array<String>) {

    "creating and linking nodes".example {
        val node1 = Node(value = 1)
        val node2 = Node(value = 2)
        val node3 = Node(value = 3)

        node1.next = node2
        node2.next = node3

        print(node1)
    }

    "push" example {
        val list = LinkedList<Int>()

        list.push(3)
        list.push(2)
        list.push(1)

        println(list)
    }

    "push and scope function" example {
        val list = LinkedList<Int>()

        list.apply {
            push(3)
            push(2)
            push(1)
        }.let { println(it) }
    }

    "fluent interface push" example {
        val list = LinkedList<Int>()
        list.push(3).push(2).push(1)
        println(list)
    }

    "append" example {
        val list = LinkedList<Int>()
        list.append(1)
        list.append(2)
        list.append(3)

        println(list)
    }

    "inserting at a particular index" example {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)

        println("Before inserting: $list")
        var middleNode = list.nodeAt(1)!!
        for (i in 1..3) {
            //여기서 middleNode 가 계속 update 되므로 조심할것.
            //새로운 middleNode 뒤에 또 insert가 됨
            middleNode = list.insert(-1 * i, middleNode)
        }
        println("After inserting: $list")
    }

    "pop" example {
        val list = LinkedList<Int>()
        list.push(3).push(2).push(1)

        println("Before popping list : $list")
        val poppedValue = list.pop()
        println("After popping list : $list")
        println("Popped value : $poppedValue")
    }

    "removing the last node" example {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)

        println("Before removing last node: $list")
        val removedValue = list.removeLast()

        println("After removing last node: $list")
        println("Removed value: $removedValue")
    }

    "removing a node after a paticular node" example {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)

        println("Before removing at particular index: $list")
        val index = 1
        val node = list.nodeAt(index - 1)!!
        val removedValue = list.removeAfter(node)

        println("After removing at index $index : $list")
        println("Removed value : $removedValue")
    }
}