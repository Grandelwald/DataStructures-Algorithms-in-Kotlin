/*
"노드"는 다음을 가져야 한다.
1. 값
2. 연결된 다음 "노드"

T에 Any를 사용하는 이유 : T값이 언제나 non-nullable 임을 보증하기 위해서이다.

그리고 노드의 toString 메서드를 사용하면,
마지막 노드라면 값만,
다음 노드가 있다면, 값과 다음 노드에 대한 정보를 스트링으로 반환한다.

 */



data class Node<T : Any>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String =
        if (next == null) "$value"
        else "$value -> ${next.toString()}"
}
