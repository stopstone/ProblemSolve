class Solution {
    fun solution(maps: Array<String>): IntArray {
        val n = maps.size
        val m = maps[0].length
        val visited = Array(n) { BooleanArray(m) }
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0)) 

        fun dfs(x: Int, y: Int): Int {
            var sum = maps[x][y].toString().toInt()
            visited[x][y] = true

            for (dir in directions) {
                val nx = x + dir[0]
                val ny = y + dir[1]

                if (nx in 0 until n && ny in 0 until m && !visited[nx][ny] && maps[nx][ny] != 'X') {
                    sum += dfs(nx, ny)
                }
            }

            return sum
        }

        val result = mutableListOf<Int>()

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (maps[i][j] != 'X' && !visited[i][j]) {
                    val islandSum = dfs(i, j)
                    result.add(islandSum)
                }
            }
        }

        return if (result.isNotEmpty()) result.sorted().toIntArray() else intArrayOf(-1)
    }
}
