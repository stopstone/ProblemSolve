fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val items = Array(n) {
        val (w, v) = readln().split(" ").map { it.toInt() }
        w to v
    }

    val dp = IntArray(k + 1) { 0 }

    for ((weight, value) in items) {
        for (j in k downTo weight) {
            dp[j] = maxOf(dp[j], dp[j - weight] + value)
        }
    }

    println(dp[k])
}
