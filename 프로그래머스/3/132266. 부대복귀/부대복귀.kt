import java.util.*

class Solution {
    fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
        val graph = Array(n + 1) { mutableListOf<Int>() }
        for ((a, b) in roads) {
            graph[a].add(b)
            graph[b].add(a)
        }

        val distances = IntArray(n + 1) { -1 }
        val queue: Queue<Int> = LinkedList()
        queue.add(destination)
        distances[destination] = 0

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            for (neighbor in graph[current]) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[current] + 1
                    queue.add(neighbor)
                }
            }
        }

        return sources.map { distances[it] }.toIntArray()
    }
}
