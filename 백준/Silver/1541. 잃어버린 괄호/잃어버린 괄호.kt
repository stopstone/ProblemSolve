fun main() {
    val input = readln()
    var result = 0

    val minusParts = input.split("-")

    result += minusParts[0].split("+").sumOf { it.toInt() }

    for (i in 1 until minusParts.size) {
        result -= minusParts[i].split("+").sumOf { it.toInt() }
    }

    println(result)
}
