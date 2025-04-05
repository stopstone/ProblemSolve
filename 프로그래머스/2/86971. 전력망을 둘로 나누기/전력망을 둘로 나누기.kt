class Solution {
    private lateinit var graph: MutableList<MutableList<Int>>
    private lateinit var visited: BooleanArray

    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer = n
        
        // 그래프 초기화
        graph = MutableList(n + 1) { mutableListOf() }
        for ((u, v) in wires) {
            graph[u].add(v)
            graph[v].add(u)
        }
        
        // 모든 전선을 끊어보며 탐색
        for ((u, v) in wires) {
            visited = BooleanArray(n + 1)
            
            // 현재 전선(u-v)을 끊고 한쪽 네트워크 크기 계산
            visited[u] = true
            val count = dfs(u, v)
            
            // 두 네트워크 크기 차이의 최소값 계산
            val diff = kotlin.math.abs(n - 2 * count)
            answer = minOf(answer, diff)
        }
        
        return answer
    }

    private fun dfs(node: Int, cutNode: Int): Int {
        var count = 1
        
        for (next in graph[node]) {
            if (!visited[next] && next != cutNode) {
                visited[next] = true
                count += dfs(next, cutNode)
            }
        }
        
        return count
    }
}
