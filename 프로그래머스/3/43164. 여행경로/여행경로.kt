class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        val route = mutableListOf<String>()
        val visited = BooleanArray(tickets.size)
        
        tickets.sortWith(compareBy({ it[0] }, { it[1] }))

        fun dfs(current: String, depth: Int): Boolean {
            route.add(current)

            if (depth == tickets.size) return true

            for (i in tickets.indices) {
                if (!visited[i] && tickets[i][0] == current) {
                    visited[i] = true
                    if (dfs(tickets[i][1], depth + 1)) return true
                    visited[i] = false
                }
            }

            route.removeAt(route.lastIndex)
            return false
        }

        dfs("ICN", 0)

        return route.toTypedArray()
    }
}
