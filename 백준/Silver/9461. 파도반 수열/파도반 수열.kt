fun main() {
    val dp = Array(110) { 0L }

    dp[1] = 1
    dp[2] = 1
    dp[3] = 1

    for (index in 4..100) {
        dp[index] = dp[index - 2] + dp[index - 3]
    }

    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        println(dp[n])
    }

}
