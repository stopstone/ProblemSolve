class Solution {
    fun solution(sequence: IntArray): Long {
        var max1 = Long.MIN_VALUE
        var max2 = Long.MIN_VALUE

        var sum1 = 0L
        var sum2 = 0L

        for (i in sequence.indices) {
            val a = sequence[i].toLong()
            
            val pulse1 = if (i % 2 == 0) 1 else -1
            val v1 = a * pulse1
            sum1 = maxOf(v1, sum1 + v1)
            max1 = maxOf(max1, sum1)

            val pulse2 = if (i % 2 == 0) -1 else 1
            val v2 = a * pulse2
            sum2 = maxOf(v2, sum2 + v2)
            max2 = maxOf(max2, sum2)
        }

        return maxOf(max1, max2)
    }
}
