import kotlin.math.min

data class Lamp(val position: Int, val power: Int)

fun main() {
    val (n, mInput) = readln().split(" ").map { it.toInt() }
    val m = mInput - 1 // 0-based 인덱스로 조정
    val lamps = Array(n) {
        val (d, w) = readln().split(" ").map { it.toInt() }
        Lamp(d, w)
    }

    val dp = Array(n) { Array(n) { LongArray(2) { -1L } } }

    val positions = lamps.map { it.position }
    val powers = lamps.map { it.power }

    // 누적합 (0~i까지의 전력량 합)
    val prefixSum = LongArray(n + 1)
    for (i in 0 until n) {
        prefixSum[i + 1] = prefixSum[i] + powers[i]
    }

    fun getPowerSum(l: Int, r: Int): Long {
        if (l > r) return 0L
        return prefixSum[r + 1] - prefixSum[l]
    }

    fun dfs(l: Int, r: Int, pos: Int): Long {
        if (l == 0 && r == n - 1) return 0L
        if (dp[l][r][pos] != -1L) return dp[l][r][pos]

        val remainingPower = getPowerSum(0, l - 1) + getPowerSum(r + 1, n - 1)
        var result = Long.MAX_VALUE

        if (pos == 0) {
            // 왼쪽 이동
            if (l > 0) {
                val dist = (positions[l] - positions[l - 1]).toLong()
                result = min(result, dfs(l - 1, r, 0) + dist * remainingPower)
            }
            // 오른쪽 이동
            if (r < n - 1) {
                val dist = (positions[r + 1] - positions[l]).toLong()
                result = min(result, dfs(l, r + 1, 1) + dist * remainingPower)
            }
        } else {
            // 왼쪽 이동
            if (l > 0) {
                val dist = (positions[r] - positions[l - 1]).toLong()
                result = min(result, dfs(l - 1, r, 0) + dist * remainingPower)
            }
            // 오른쪽 이동
            if (r < n - 1) {
                val dist = (positions[r + 1] - positions[r]).toLong()
                result = min(result, dfs(l, r + 1, 1) + dist * remainingPower)
            }
        }

        dp[l][r][pos] = result
        return result
    }

    println(minOf(dfs(m, m, 0), dfs(m, m, 1)))
}
