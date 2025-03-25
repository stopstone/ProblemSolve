class Solution {
    fun solution(weights: IntArray): Long {
        var answer = 0L
        val countMap = mutableMapOf<Int, Int>()

        // 가능한 무게 비율 (거리비 역수)
        val ratios = listOf(
            Pair(1, 1), Pair(2, 3), Pair(3, 2),
            Pair(1, 2), Pair(2, 1), Pair(3, 4), 
            Pair(4, 3),
        )

        for (weight in weights) {
            for ((a, b) in ratios) {
                if ((weight * a) % b == 0) {
                    val match = (weight * a) / b
                    answer += countMap.getOrDefault(match, 0)
                }
            }
            countMap[weight] = countMap.getOrDefault(weight, 0) + 1
        }

        return answer
    }
}