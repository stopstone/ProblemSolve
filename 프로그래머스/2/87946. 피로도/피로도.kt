class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        val permutations = mutableListOf<List<IntArray>>()
        permute(dungeons.toList(), listOf(), permutations)

        var maxCount = 0
        for (order in permutations) {
            var currentK = k
            var count = 0
            for ((minReq, cost) in order) {
                if (currentK >= minReq) {
                    currentK -= cost
                    count++
                } else {
                    break
                }
            }
            maxCount = maxOf(maxCount, count)
        }

        return maxCount
    }

    private fun permute(
        remain: List<IntArray>,
        path: List<IntArray>,
        result: MutableList<List<IntArray>>
    ) {
        if (remain.isEmpty()) {
            result.add(path)
            return
        }

        for (i in remain.indices) {
            val newRemain = remain.toMutableList().apply { removeAt(i) }
            val newPath = path + remain[i]
            permute(newRemain, newPath, result)
        }
    }
}
