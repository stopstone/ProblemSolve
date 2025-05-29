import java.util.LinkedList
import java.util.Queue

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        // 1. 그래프 구성
        val graph = Array(n + 1) { mutableListOf<Int>() }
        for ((a, b) in edge) {
            graph[a].add(b)
            graph[b].add(a)
        }

        // 2. 거리 배열 초기화 (-1로 설정해서 방문 여부 체크도 겸함)
        val distance = IntArray(n + 1) { -1 }
        val queue: Queue<Int> = LinkedList()
        queue.add(1)
        distance[1] = 0

        // 3. BFS 수행
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            for (neighbor in graph[current]) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1
                    queue.add(neighbor)
                }
            }
        }

        // 4. 가장 먼 거리 구하기
        val maxDistance = distance.maxOrNull() ?: 0
        return distance.count { it == maxDistance }
    }
}
