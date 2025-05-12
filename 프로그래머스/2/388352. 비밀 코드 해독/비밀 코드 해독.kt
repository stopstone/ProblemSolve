class Solution {
    fun solution(n: Int, q: Array<IntArray>, ans: IntArray): Int {
        var count = 0

        val nums = (1..n).toList()
        val combs = mutableListOf<List<Int>>()
        generateCombinations(nums, 5, 0, mutableListOf(), combs)

        for (comb in combs) {
            var isValid = true
            for (i in q.indices) {
                val intersectionSize = comb.count { it in q[i] }
                if (intersectionSize != ans[i]) {
                    isValid = false
                    break
                }
            }
            if (isValid) count++
        }

        return count
    }

    private fun generateCombinations(
        arr: List<Int>, r: Int,
        start: Int, temp: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        if (temp.size == r) {
            result.add(temp.toList())
            return
        }

        for (i in start until arr.size) {
            temp.add(arr[i])
            generateCombinations(arr, r, i + 1, temp, result)
            temp.removeAt(temp.size - 1)
        }
    }
}
