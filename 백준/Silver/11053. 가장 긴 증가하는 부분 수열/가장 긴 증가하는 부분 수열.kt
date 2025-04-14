fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val dp = MutableList(n) { 1 }

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (arr[j] < arr[i]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }

    println(dp.maxOrNull())
}
