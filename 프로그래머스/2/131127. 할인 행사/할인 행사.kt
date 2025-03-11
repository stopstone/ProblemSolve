import java.util.*


class Solution {
    fun solution(
        want: Array<String>,
        number: IntArray,
        discount: Array<String>,
    ): Int {
        val wantMap = want.zip(number.toTypedArray()).toMap()
        val windowSize = number.sum()
        var count = 0

        val currentDiscount = discount.take(windowSize).groupingBy { it }.eachCount().toMutableMap()

        if (currentDiscount == wantMap) count++

        for (i in 0 until discount.size - windowSize) {
            val outgoing = discount[i]
            val incoming = discount[i + windowSize]

            currentDiscount[outgoing] = currentDiscount.getOrDefault(outgoing, 0) - 1
            if (currentDiscount[outgoing] == 0) currentDiscount.remove(outgoing)

            currentDiscount[incoming] = currentDiscount.getOrDefault(incoming, 0) + 1

            if (currentDiscount == wantMap) count++
        }

        return count
    }
}