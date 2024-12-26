fun main() {
    val number = readln().toInt()
    val dp = Array<Long>(1001) { 0 }

    dp[0] = 0
    dp[1] = 1

    for (index in 2..number) {
        dp[index] = dp[index - 1] + dp[index - 2]
    }
    print(dp[number])
}
