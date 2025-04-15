fun main() {
    val n = readln().toInt()
    val mod = 15746
    val dp = IntArray(n + 1)

    dp[1] = 1
    if (n >= 2) dp[2] = 2

    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % mod
    }

    println(dp[n])
}
