import java.util.LinkedList
import java.util.Queue

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        if (x == y) return 0
        
        val visited = BooleanArray(1_000_001)
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(x, 0))
        visited[x] = true

        while (queue.isNotEmpty()) {
            val (current, count) = queue.poll()

            val nextList = listOf(current + n, current * 2, current * 3)
            for (next in nextList) {
                if (next > y || visited[next]) continue
                if (next == y) return count + 1
                visited[next] = true
                queue.add(Pair(next, count + 1))
            }
        }

        return -1
    }
}
