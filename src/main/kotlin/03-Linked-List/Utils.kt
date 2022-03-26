package `03-Linked-List`/*
`03-Linked-List`.example 함수
`03-Linked-List`.example 함수는 확장함수다.

String 타입 뒤에 확장하여 사용하고,
매개변수로 람다함수를 받는다.

example은 실행하면,
수신객체 String을 출력하고
내가 쓴 람다함수를 실행한다.
그리고 한줄 띄어준다.

그런데 example은 매개변수가 하나이고 여러개가 될 수 없으므로 infix 함수가 될 수 있다.
그래서 점 없이 바로 쓸수있다.
 */

infix fun String.example(function: () -> Unit) {
    println("---Example of $this---")
    function()
    println()
}