class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        // 선수 이름 -> 위치 맵핑을 저장
        val positions = players.withIndex()
            .associate { it.value to it.index }
            .toMutableMap()
        
        callings.forEach { player ->
            // 현재 선수의 위치
            val pos = positions[player]!!
            // 앞 선수의 이름
            val front = players[pos - 1]
            
            // 위치 교환
            players[pos] = front
            players[pos - 1] = player
            
            // 맵의 위치 정보 업데이트
            positions[player] = pos - 1
            positions[front] = pos
        }
        
        return players
    }
}