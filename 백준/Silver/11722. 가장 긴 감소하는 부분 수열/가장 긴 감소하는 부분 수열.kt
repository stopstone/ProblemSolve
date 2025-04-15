fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }  // 수열 A

    val dp = IntArray(n) { 1 }
    for (i in 1 until n) {
        for (j in 0 until i) {
            if (arr[i] < arr[j]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }

    // 가장 긴 감소하는 부분 수열의 길이 출력
    println(dp.maxOrNull())
}
