fun main() {

    val (a, b) = readln().split(" ").map { it.toInt() }
    val numbers = mutableListOf<Int>()
    var sum = 0

    for (i in 1..b) {
        repeat(i) {
            numbers.add(i)
        }
    }

    for (i in a..b) {
        sum += numbers[i - 1]
    }

    print(sum)
}