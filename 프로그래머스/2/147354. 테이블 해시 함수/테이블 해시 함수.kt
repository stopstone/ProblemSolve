class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        val sortedData = data.sortedWith(compareBy({ it[col - 1] }, { -it[0] }))
        var result = 0
        
        for (i in row_begin - 1..row_end - 1) {
            val row = sortedData[i]
            val sumOfRemainders = row.mapIndexed { index, value -> value % (i + 1) }.sum()
            result = result xor sumOfRemainders
        }

        return result
    }
}
