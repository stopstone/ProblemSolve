class Solution {
    fun solution(players: IntArray, m: Int, k: Int): Int {
        var answer = 0
        val runningServers = IntArray(24) { 0 }
        
        for (time in 0 until 24) {
            val neededServers = players[time] / m
            
            if (neededServers > runningServers[time]) {
                val additionalServers = neededServers - runningServers[time]
                answer += additionalServers
                
                for (i in 0 until k) {
                    if (time + i < 24) {
                        runningServers[time + i] += additionalServers
                    }
                }
            }
        }
        
        return answer
    }
}