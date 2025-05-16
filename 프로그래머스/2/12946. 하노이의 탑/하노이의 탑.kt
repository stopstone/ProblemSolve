class Solution {
    fun solution(n: Int): Array<IntArray> {
        val result = mutableListOf<IntArray>()

        fun hanoi(n: Int, from: Int, to: Int, via: Int) {
            if (n == 1) {
                result.add(intArrayOf(from, to))
                return
            }
            hanoi(n - 1, from, via, to)
            result.add(intArrayOf(from, to))
            hanoi(n - 1, via, to, from)
        }

        hanoi(n, 1, 3, 2)
        return result.toTypedArray()
    }
}
