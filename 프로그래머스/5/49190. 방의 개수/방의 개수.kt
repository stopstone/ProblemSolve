class Solution {
    fun solution(arrows: IntArray): Int {
        val dx = arrayOf(0, 1, 1, 1, 0, -1, -1, -1)
        val dy = arrayOf(1, 1, 0, -1, -1, -1, 0, 1)

        val visited = mutableSetOf<Pair<Int, Int>>()    
        val edges = mutableSetOf<Triple<Int, Int, Int>>()

        var x = 0
        var y = 0
        visited.add(x to y)

        var answer = 0

        for (dir in arrows) {
            repeat(2) {
                val nx = x + dx[dir]
                val ny = y + dy[dir]

                val now = x to y
                val next = nx to ny

                val edge = Triple(x, y, dir)
                val reverseEdge = Triple(nx, ny, (dir + 4) % 8)

                if (next in visited && edge !in edges && reverseEdge !in edges) {
                    answer++
                }

                visited.add(next)
                edges.add(edge)
                edges.add(reverseEdge)

                x = nx
                y = ny
            }
        }

        return answer
    }
}
