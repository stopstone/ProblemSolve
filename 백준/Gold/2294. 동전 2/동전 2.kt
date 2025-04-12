fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val coins = IntArray(n) { readln().toInt() }
    val dp = IntArray(k + 1) { Int.MAX_VALUE }
    dp[0] = 0

    for (coin in coins) {
        for (i in coin..k) {
            if (dp[i - coin] != Int.MAX_VALUE) {
                dp[i] = minOf(dp[i], dp[i - coin] + 1)
            }
        }
    }

    println(if (dp[k] == Int.MAX_VALUE) -1 else dp[k])
}
