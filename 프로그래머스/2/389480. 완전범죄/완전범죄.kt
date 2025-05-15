class Solution {
    fun solution(info: Array<IntArray>, n: Int, m: Int): Int {
        val maxA = n
        val maxB = m
        val itemCount = info.size

        // 3차원 dp[i][a][b] -> i번째까지 고려했을 때 A, B의 흔적 합
        val dp = Array(itemCount + 1) { Array(maxA) { BooleanArray(maxB) } }
        dp[0][0][0] = true

        for (i in 0 until itemCount) {
            for (a in 0 until maxA) {
                for (b in 0 until maxB) {
                    if (!dp[i][a][b]) continue

                    val aNext = a + info[i][0]
                    if (aNext < maxA) {
                        dp[i + 1][aNext][b] = true
                    }

                    val bNext = b + info[i][1]
                    if (bNext < maxB) {
                        dp[i + 1][a][bNext] = true
                    }
                }
            }
        }

        var minA = Int.MAX_VALUE
        for (a in 0 until maxA) {
            for (b in 0 until maxB) {
                if (dp[itemCount][a][b]) {
                    minA = minOf(minA, a)
                }
            }
        }

        return if (minA == Int.MAX_VALUE) -1 else minA
    }
}
