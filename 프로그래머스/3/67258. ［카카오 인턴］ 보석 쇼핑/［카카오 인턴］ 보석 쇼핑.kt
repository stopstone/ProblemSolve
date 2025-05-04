class Solution {
    fun solution(gems: Array<String>): IntArray {
        val gemKinds = gems.toSet().size
        val gemMap = mutableMapOf<String, Int>()

        var answer = intArrayOf(0, gems.size - 1)
        var left = 0
        var right = 0

        gemMap[gems[0]] = 1

        while (left <= right && right < gems.size) {
            if (gemMap.size == gemKinds) {
                if ((right - left) < (answer[1] - answer[0])) {
                    answer = intArrayOf(left, right)
                }

                gemMap[gems[left]] = gemMap[gems[left]]!! - 1
                if (gemMap[gems[left]] == 0) {
                    gemMap.remove(gems[left])
                }
                left++
            } else {
                right++
                if (right < gems.size) {
                    gemMap[gems[right]] = gemMap.getOrDefault(gems[right], 0) + 1
                }
            }
        }

        return intArrayOf(answer[0] + 1, answer[1] + 1)
    }
}
