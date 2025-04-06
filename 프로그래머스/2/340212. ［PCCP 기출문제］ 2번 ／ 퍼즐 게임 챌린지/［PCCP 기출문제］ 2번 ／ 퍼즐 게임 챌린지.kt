class Solution {
    fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {
        val n = diffs.size
        val maxDiff = diffs.maxOrNull() ?: 1
        
        var lo = 1
        var hi = maxDiff
        var ans = hi
        
        while (lo <= hi) {
            val mid = (lo + hi) / 2
            var totalTime = times[0].toLong()  // 첫 번째 퍼즐은 항상 시간만 사용 (diffs[0] = 1)
            var valid = true
            
            for (i in 1 until n) {
                if (diffs[i] <= mid) {
                    totalTime += times[i]
                } else {
                    // 틀린 횟수 : diffs[i] - mid
                    val mistakes = diffs[i] - mid
                    // 틀릴 때마다 시간 : 현재 퍼즐 시간 + 이전 퍼즐 시간
                    totalTime += mistakes.toLong() * (times[i] + times[i-1]) + times[i]
                }
                // 시간 초과면 더 이상 계산할 필요 없음.
                if (totalTime > limit) {
                    valid = false
                    break
                }
            }
            
            if (valid) {
                ans = mid
                hi = mid - 1
            } else {
                lo = mid + 1
            }
        }
        
        return ans
    }
}
