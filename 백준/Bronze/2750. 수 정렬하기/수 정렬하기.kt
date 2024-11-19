fun main() {
    val size = readln().toInt()
    val list = IntArray(size) {
        readln().toInt()
    }.toList()

    list.sorted().forEach {
        println(it)
    }
}