class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        val graph = Array(n + 1) { BooleanArray(n + 1) }

        for ((win, lose) in results) {
            graph[win][lose] = true
        }

        for (k in 1..n) {
            for (i in 1..n) {
                for (j in 1..n) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true
                    }
                }
            }
        }

        var answer = 0

        for (i in 1..n) {
            var count = 0
            for (j in 1..n) {
                if (i == j) continue
                if (graph[i][j] || graph[j][i]) {
                    count++
                }
            }
            if (count == n - 1) answer++
        }

        return answer
    }
}
