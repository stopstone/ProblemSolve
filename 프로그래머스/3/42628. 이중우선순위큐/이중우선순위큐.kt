import java.util.*

class Solution {
    fun solution(operations: Array<String>): IntArray {
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
        val countMap = mutableMapOf<Int, Int>()

        for (op in operations) {
            val (command, valueStr) = op.split(" ")
            val value = valueStr.toInt()

            when (command) {
                "I" -> {
                    minHeap.add(value)
                    maxHeap.add(value)
                    countMap[value] = countMap.getOrDefault(value, 0) + 1
                }

                "D" -> {
                    if (countMap.isEmpty()) continue

                    val heap = if (value == 1) maxHeap else minHeap
                    while (heap.isNotEmpty()) {
                        val num = heap.poll()
                        val count = countMap.getOrDefault(num, 0)
                        if (count > 0) {
                            if (count == 1) countMap.remove(num)
                            else countMap[num] = count - 1
                            break
                        }
                    }
                }
            }
        }

        // 남은 값들 중 유효한 값만 찾기
        val validNumbers = countMap.keys
        if (validNumbers.isEmpty()) return intArrayOf(0, 0)

        return intArrayOf(validNumbers.maxOrNull()!!, validNumbers.minOrNull()!!)
    }
}
