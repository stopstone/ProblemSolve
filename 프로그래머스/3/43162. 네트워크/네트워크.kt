class Solution {
    private lateinit var visited: BooleanArray
    private lateinit var computers: Array<IntArray>

    fun solution(
        n: Int, 
        computers: Array<IntArray>,
    ): Int {
        var answer = 0
        visited = BooleanArray(n)
        this.computers = computers

        for(i in 0 until n) {
            if(!visited[i]) {
                dfs(i)
                answer++
            }
        }
        return answer
    }
    
    private fun dfs(node: Int) {
        visited[node] = true
        for(i in 0 until computers.size) {
            if(!visited[i] && computers[node][i] == 1) {
                dfs(i)
            }
        }
    }
}