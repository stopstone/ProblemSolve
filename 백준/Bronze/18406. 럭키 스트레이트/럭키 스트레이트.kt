fun main() {
    val input = readLine()!!
    val length = input.length
    val half = length / 2

    val leftSum = input.substring(0, half).sumOf { it - '0' }
    val rightSum = input.substring(half).sumOf { it - '0' }

    if (leftSum == rightSum) {
        println("LUCKY")
    } else {
        println("READY")
    }
}
