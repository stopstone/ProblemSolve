class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        val countOfTangerine = mutableMapOf<Int, Int>()
        var selected = 0
        var answer = 0
        
        for (count in tangerine) {
            countOfTangerine[count] = countOfTangerine.getOrDefault(count, 0).plus(1)
        }

        val sortedCount = countOfTangerine.values.sortedDescending()

        for (count in sortedCount) {
            selected += count
            answer++

            if (selected >= k) {
                break
            }
        }
        return answer
    }
}