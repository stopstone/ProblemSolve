class Solution {
    fun solution(a: IntArray): Int {
        val countMap = mutableMapOf<Int, Int>()
        for (num in a) {
            countMap[num] = countMap.getOrDefault(num, 0) + 1
        }

        var maxLength = 0

        for ((key, count) in countMap) {
            if (count * 2 <= maxLength) continue

            var pairCount = 0
            var i = 0
            while (i < a.size - 1) {
                if ((a[i] == key || a[i + 1] == key) && a[i] != a[i + 1]) {
                    pairCount++
                    i += 2
                } else {
                    i++
                }
            }

            maxLength = maxOf(maxLength, pairCount * 2)
        }

        return maxLength
    }
}
