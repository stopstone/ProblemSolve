class Solution {
    fun solution(numbers: LongArray): LongArray {
        return numbers.map { x ->
            if (x % 2 == 0L) {
                x + 1
            } else {
                var bit = 1L
                while ((x and bit) != 0L) {
                    bit = bit shl 1
                }
                (x + bit) - (bit shr 1)
            }
        }.toLongArray()
    }
}
