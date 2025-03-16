class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val result = mutableListOf<Int>()
        val queue: ArrayDeque<Int> = ArrayDeque()

        // 각 기능이 완료되어 배포되는 최종 일수를 계산하여 queue에 저장
        for (i in progresses.indices) {
            val remain = 100 - progresses[i]
            val days = (remain + speeds[i] - 1) / speeds[i]
            queue.add(days)
        }

        while (queue.isNotEmpty()) {
            val first = queue.removeFirst()
            var count = 1

            while (queue.isNotEmpty() && queue.first() <= first) {
                queue.removeFirst()
                count++
            }
            result.add(count)
        }
        return result.toIntArray()
    }
}
