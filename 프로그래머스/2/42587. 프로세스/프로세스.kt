import java.util.LinkedList
import java.util.Queue


data class Process(
    val priority: Int,
    val isTarget: Boolean,
)

class Solution {
    fun solution(
        priorities: IntArray,
        location: Int,
    ): Int {
        val queue: Queue<Process> = LinkedList()

        // 0. priorities의 배열을 큐에 넣습니다.
        priorities.forEachIndexed { index, priority ->
            queue.add(Process(priority, (index == location)))
        }

        var order = 0
        while (queue.isNotEmpty()) {
            // 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
            val process = queue.poll()

            // 2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면
            // 방금 꺼낸 프로세스를 다시 큐에 넣습니다.

            val hasHigher = queue.any { it.priority > process.priority }

            if (hasHigher) {
                queue.add(process)
            } else {
                // 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
                // 3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
                order++
                if (process.isTarget) {
                    return order
                }
            }

        }
        return order
    }
}


fun main() {
    val result = Solution().solution(
        priorities = intArrayOf(1, 1, 9, 1, 1, 1),
        location = 0,
    )
    println(result)
}