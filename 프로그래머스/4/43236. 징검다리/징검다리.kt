class Solution {
    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        val sortedRocks = rocks.sorted() + distance
        var left = 1
        var right = distance
        var answer = 0

        while (left <= right) {
            val mid = (left + right) / 2
            var prev = 0
            var removed = 0

            for (rock in sortedRocks) {
                val gap = rock - prev
                if (gap < mid) {
                    removed++
                } else {
                    prev = rock
                }
            }

            if (removed > n) {
                right = mid - 1
            } else {
                answer = mid
                left = mid + 1
            }
        }

        return answer
    }
}
