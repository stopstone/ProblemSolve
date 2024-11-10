fun main() {
    val result = processInput()
    printResult(result)
}

fun processInput(): List<String> {
    val T = readln().toInt()
    val words = mutableListOf<String>()

    repeat(T) {
        val str = readln().split(" ").map { it.reversed() }
        words.add(str.joinToString(separator = " "))
    }

    return words
}

fun printResult(words: List<String>) {
    words.forEach {
        println(it)
    }
}