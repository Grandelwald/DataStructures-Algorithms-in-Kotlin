package `05-Queues`

infix fun String.example(function : () -> Unit){
    println("example of $this")
    function()
    println()
}