import java.util.*

class Solution {
    fun solution(order: IntArray): Int {
        val subStack = Stack<Int>()
        var current = 1            
        var index = 0
        val n = order.size

        while (current <= n) {
            if (order[index] == current) {
                // 현재 박스를 바로 트럭에 실을 수 있는 경우
                index++
                current++
            } else if (subStack.isNotEmpty() && subStack.peek() == order[index]) {
                // 보조 컨테이너 벨트에서 트럭에 실을 수 있는 경우
                subStack.pop()
                index++
            } else {
                // 보조 컨테이너 벨트에 현재 박스를 넣는다
                subStack.push(current)
                current++
            }
        }

        // 남은 보조 스택도 체크
        while (subStack.isNotEmpty() && subStack.peek() == order[index]) {
            subStack.pop()
            index++
        }

        return index
    }
}
