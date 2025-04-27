fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(' ').map { it.toInt() }

    val compressed = arr
        .distinct()
        .sorted()
        .withIndex()
        .associate { it.value to it.index }

    println(arr.joinToString(" ") { compressed[it].toString() })
}
