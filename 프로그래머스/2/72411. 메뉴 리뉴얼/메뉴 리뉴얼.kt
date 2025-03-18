class Solution {
    fun solution(
        orders: Array<String>,
        course: IntArray,
    ): Array<String> {
        val result = mutableListOf<String>()

        for (c in course) {
            val combinationCount = mutableMapOf<String, Int>() // 조합별 주문 수 저장

            for (order in orders) {
                val sortedOrder = order.toCharArray().sorted()
                val combinations = getCombinations(sortedOrder, c)
                for (comb in combinations) {
                    val key = comb.joinToString("")
                    combinationCount[key] = combinationCount.getOrDefault(key, 0) + 1
                }
            }

            // 가장 많이 등장한 조합 찾기
            val maxCount = combinationCount.values.maxOrNull() ?: 0
            if (maxCount >= 2) {
                combinationCount
                    .filter { it.value == maxCount }
                    .keys
                    .forEach { result.add(it) }
            }
        }

        return result.sorted().toTypedArray()
    }

    // 조합 생성 함수
    private fun getCombinations(sortedOrder: List<Char>, count: Int): List<List<Char>> {
        val result = mutableListOf<List<Char>>()

        fun dfs(start: Int, path: MutableList<Char>) {
            if (path.size == count) {
                result.add(ArrayList(path))
                return
            }

            for (i in start until sortedOrder.size) {
                path.add(sortedOrder[i])
                dfs(i + 1, path)
                path.removeAt(path.size - 1)
            }
        }
        dfs(0, mutableListOf())
        return result
    }
}
