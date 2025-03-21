class Solution {
    fun solution(numbers: IntArray): IntArray {
        val n = numbers.size
        val answer = IntArray(n) { -1 }
        val stack = ArrayDeque<Int>()

        for (i in n - 1 downTo 0) {
            while (stack.isNotEmpty() && stack.last() <= numbers[i]) {
                stack.removeLast()
            }
            // 스택이 비어있지 않다면 top이 뒷 큰수
            if (stack.isNotEmpty()) {
                answer[i] = stack.last()
            }

            // 현재 값을 스택에 push
            stack.addLast(numbers[i])
        }
        return answer
    }
}
