class Solution {
    fun solution(n: Int, l: Long, r: Long): Int {
        return countOnes(n, l - 1, r - 1)
    }

    private fun countOnes(n: Int, l: Long, r: Long): Int {
        fun isOne(n: Int, index: Long): Int {
            if (n == 0) return 1 
            val len = pow5(n - 1)
            val section = index / len
            return if (section == 2L) 0 
            else isOne(n - 1, index % len)
        }

        var count = 0
        for (i in l..r) {
            count += isOne(n, i)
        }
        return count
    }

    private fun pow5(n: Int): Long {
        var result = 1L
        repeat(n) { result *= 5 }
        return result
    }
}
