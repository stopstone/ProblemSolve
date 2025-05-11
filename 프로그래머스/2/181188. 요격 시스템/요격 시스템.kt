class Solution {
    fun solution(targets: Array<IntArray>): Int {
        targets.sortBy { it[1] }

        var count = 0
        var lastIntercept = -1.0
        for ((s, e) in targets) {
            if (lastIntercept <= s.toDouble()) {
                lastIntercept = e.toDouble() - 0.1
                count++
            }
        }

        return count
    }
}
