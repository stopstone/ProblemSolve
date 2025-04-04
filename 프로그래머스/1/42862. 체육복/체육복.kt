class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        // lost와 reserve에서 겹치는 학생 제거
        val realLost = lost.filter { it !in reserve }.sorted()
        val realReserve = reserve.filter { it !in lost }.sorted()

        var available = n - realLost.size

        val mutableReserve = realReserve.toMutableList()

        for (student in realLost) {
            if (student - 1 in mutableReserve) {
                mutableReserve.remove(student - 1)
                available++
            } else if (student + 1 in mutableReserve) {
                mutableReserve.remove(student + 1)
                available++
            }
        }

        return available
    }
}
