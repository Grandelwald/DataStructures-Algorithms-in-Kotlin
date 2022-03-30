package `04-Stack`


infix fun String.example(function : ()->Unit){
    println("---Example of $this---")
    function()
    println()
}

fun String.checkParentheses() : Boolean {
    val stack = StackImpl<Char>()

    for (character in this) {
        when ( character ){
            '(' -> stack.push(character)
            ')' -> if (stack.isEmpty) {
                return false
            } else {
                stack.pop()
            }
        }
    }
    return  stack.isEmpty
}