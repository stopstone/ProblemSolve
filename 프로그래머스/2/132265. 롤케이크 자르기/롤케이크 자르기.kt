class Solution {
    fun solution(topping: IntArray): Int {
        var answer = 0

        val leftSet = mutableSetOf<Int>()
        val rightMap = mutableMapOf<Int, Int>()

        // 초기: 모든 토핑을 오른쪽 Map에 저장
        for (t in topping) {
            rightMap[t] = rightMap.getOrDefault(t, 0) + 1
        }

        for (item in topping) {
            leftSet.add(item)
            rightMap[item] = rightMap[item]!! - 1

            if (rightMap[item] == 0) {
                rightMap.remove(item)
            }

            if (leftSet.size == rightMap.size) {
                answer++
            }
        }
        return answer
    }
}