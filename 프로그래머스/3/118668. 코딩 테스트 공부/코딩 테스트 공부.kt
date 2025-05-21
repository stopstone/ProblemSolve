class Solution {
    fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {
        val maxAlp = problems.maxOf { it[0] }.coerceAtLeast(alp)
        val maxCop = problems.maxOf { it[1] }.coerceAtLeast(cop)

        val dp = Array(maxAlp + 2) { IntArray(maxCop + 2) { Int.MAX_VALUE } }
        dp[alp.coerceAtMost(maxAlp)][cop.coerceAtMost(maxCop)] = 0

        for (i in alp..maxAlp) {
            for (j in cop..maxCop) {
                val cur = dp[i][j]
                // 알고력 +1
                if (i + 1 <= maxAlp)
                    dp[i + 1][j] = minOf(dp[i + 1][j], cur + 1)
                // 코딩력 +1
                if (j + 1 <= maxCop)
                    dp[i][j + 1] = minOf(dp[i][j + 1], cur + 1)

                // 문제 풀기
                for ((reqAlp, reqCop, rwdAlp, rwdCop, cost) in problems) {
                    if (i >= reqAlp && j >= reqCop) {
                        val ni = (i + rwdAlp).coerceAtMost(maxAlp)
                        val nj = (j + rwdCop).coerceAtMost(maxCop)
                        dp[ni][nj] = minOf(dp[ni][nj], cur + cost)
                    }
                }
            }
        }

        return dp[maxAlp][maxCop]
    }
}
