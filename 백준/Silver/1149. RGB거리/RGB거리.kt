fun main() {
    val n = readLine()!!.toInt()
    val cost = Array(n) { IntArray(3) }
    val dp = Array(n) { IntArray(3) }

    for (i in 0 until n) {
        val (r, g, b) = readLine()!!.split(" ").map { it.toInt() }
        cost[i][0] = r
        cost[i][1] = g
        cost[i][2] = b
    }

    // 초기값 설정
    dp[0][0] = cost[0][0]
    dp[0][1] = cost[0][1]
    dp[0][2] = cost[0][2]

    for (i in 1 until n) {
        dp[i][0] = minOf(dp[i-1][1], dp[i-1][2]) + cost[i][0]
        dp[i][1] = minOf(dp[i-1][0], dp[i-1][2]) + cost[i][1]
        dp[i][2] = minOf(dp[i-1][0], dp[i-1][1]) + cost[i][2]
    }

    println(minOf(dp[n-1][0], dp[n-1][1], dp[n-1][2]))
}
