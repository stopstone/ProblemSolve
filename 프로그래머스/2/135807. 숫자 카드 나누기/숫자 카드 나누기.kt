class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        val gcdA = arrayA.reduce(::gcd)
        val gcdB = arrayB.reduce(::gcd)

        val candidateA = getMaxValidDivisor(gcdA, arrayB)
        val candidateB = getMaxValidDivisor(gcdB, arrayA)

        return maxOf(candidateA, candidateB)
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    private fun getMaxValidDivisor(gcd: Int, otherArray: IntArray): Int {
        var result = 0
        for (i in 1..Math.sqrt(gcd.toDouble()).toInt()) {
            if (gcd % i == 0) {
                val d1 = i
                val d2 = gcd / i

                if (otherArray.none { it % d1 == 0 }) {
                    result = maxOf(result, d1)
                }
                if (otherArray.none { it % d2 == 0 }) {
                    result = maxOf(result, d2)
                }
            }
        }
        return result
    }
}
