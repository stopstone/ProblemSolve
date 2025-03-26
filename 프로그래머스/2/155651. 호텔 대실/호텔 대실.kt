import java.util.*

class Solution {
    fun solution(bookTime: Array<Array<String>>): Int {
        val roomQueue = PriorityQueue<Int>()
        
         // 시작 시간 기준으로 정렬하고, 종료 시간은 +10분 청소 시간 포함
        val times = bookTime.map { time ->
            Pair(time[0].toMinute(), time[1].toMinute() + 10)
        }.sortedBy { it.first }
     
      // 현재 가장 빨리 끝나는 방의 시간과 비교해서 재사용 가능하면 제거
        for((start, end) in times) {
            if(roomQueue.isNotEmpty() && roomQueue.peek() <= start) {
                roomQueue.poll()
            }
            roomQueue.add(end)
        }
        
        // Queue의 크기는 방의 크기
        return roomQueue.size
    }
    
    fun String.toMinute(): Int {
        // HH:MM을 변환
        val (h, m) = this.split(":").map { it.toInt() }
        return h * 60 + m
    }
}

