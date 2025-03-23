data class Plan(val name: String, var start: Int, var play: Int)

class Solution {
    fun solution(
        plans: Array<Array<String>>,
    ): Array<String> {
        // 남은 과제를 담을 스택
        val stack = ArrayDeque<Plan>()
        val answer = mutableListOf<String>()

        // 시간순으로 과제 계획 정리
        val sorted = plans.map { Plan(it[0], it[1].toMinutes(), it[2].toInt()) }
            .sortedBy { it.start }

        for (i in 0 until sorted.size) {
            val now = sorted[i]
            val nextTime = if (i < sorted.size - 1) sorted[i + 1].start else Int.MAX_VALUE
            var time = now.play

            var gap = nextTime - now.start
            if (gap >= time) {
                answer.add(now.name)
                gap -= time

                // 쉬는 시간 동안 멈춘 과제 처리
                while (gap > 0 && stack.isNotEmpty()) {
                    val paused = stack.removeLast()
                    if (paused.play <= gap) {
                        gap -= paused.play
                        answer.add(paused.name)
                    } else {
                        paused.play -= gap
                        stack.addLast(paused)
                        break
                    }
                }
            } else {
                // 다 못하면 스택에 저장
                now.play -= gap
                stack.addLast(now)
            }
        }

        // 남은 과제 처리
        while (stack.isNotEmpty()) {
            answer.add(stack.removeLast().name)
        }

        return answer.toTypedArray()
    }

    // 문자열 "HH:MM"을 분으로 바꾸는 함수
    private fun String.toMinutes(): Int {
        val (h, m) = this.split(":").map { it.toInt() }
        return h * 60 + m
    }
}