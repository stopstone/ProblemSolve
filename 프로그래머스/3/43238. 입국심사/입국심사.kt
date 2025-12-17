class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        var low: Long = 0
        var high = times[times.size - 1] * n.toLong()
        var mid: Long = 0

        while (low <= high) {
            mid = (low + high) / 2
            var sum: Long = 0

            for (i in times.indices) {
                sum += mid / times[i]
            }

            if (sum < n) {
                low = mid + 1
            } else {
                high = mid - 1
                answer = mid
            }
        }
        times.sort()

        return answer
    }
}

fun main() {
    val result = Solution().solution(
        n = 6,
        times = intArrayOf(7, 10),
    )
    println(result)
}