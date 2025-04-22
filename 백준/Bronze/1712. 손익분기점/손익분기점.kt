fun main() {
    val (A, B, C) = readln().split(" ").map { it.toLong() }

    if (C <= B) {
        println(-1)
    } else {
        println(A / (C - B) + 1)
    }
}
