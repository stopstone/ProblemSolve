class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        // 이진 탐색의 범위 설정
        var left = 1
        var right = 200_000_000 // stones 배열의 최대값
        
        // 이진 탐색 수행
        while (left <= right) {
            val mid = (left + right) / 2
            
            if (canCross(stones, k, mid)) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return right
    }
    
    // 특정 수의 친구들이 건널 수 있는지 확인하는 함수
    private fun canCross(stones: IntArray, k: Int, friends: Int): Boolean {
        var skipCount = 0 // 건너뛴 칸 수
        
        for (stone in stones) {
            if (stone - friends < 0) {
                skipCount++
                if (skipCount >= k) return false
            } else {
                skipCount = 0
            }
        }
        
        return true
    }
} 