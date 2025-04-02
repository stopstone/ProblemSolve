class Solution {
    fun solution(elements: IntArray): Int {
        val n = elements.size
        val answers = mutableSetOf<Int>()
        
        for (length in 1..n) {
            for (start in 0 until n) {
                var sum = 0
                for (i in 0 until length) {
                    sum += elements[(start + i) % n]
                }
                answers.add(sum)
            }
        }
        return answers.size
    }
}