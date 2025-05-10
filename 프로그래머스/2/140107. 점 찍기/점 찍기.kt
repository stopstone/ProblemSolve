class Solution {
    fun solution(k: Int, d: Int): Long {
        var answer = 0L
        val dd = 1L * d * d
        var x = 0L
        
        while (x <= d) {
            val maxY = Math.sqrt((dd - x * x).toDouble()).toLong()
            answer += (maxY / k + 1)
            x += k
        }
        return answer
    }
}
