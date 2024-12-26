fun main() {
    val dp = Array(12) { 0 }
    val T = readln().toInt()

    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (index in 4..11) {
        dp[index] = dp[index - 1] + dp[index - 2] + dp[index -3]
    }

    repeat(T) {
        val n = readln().toInt()
        println(dp[n])
    }
}
