class Solution {
    fun solution(
        clothes: Array<Array<String>>
    ): Int {
        var answer = 1
        val clothesMap = mutableMapOf<String, Int>()

        // 종류별 의상 개수 계산
        for (item in clothes) {
            val category = item[1]
            clothesMap[category] = clothesMap.getOrDefault(category, 0) + 1
        }

        // 입은 경우 카운트, +1은 안입은 경우
        for (count in clothesMap.values) {
            answer *= (count + 1)
        }

        // 아무것도 입지 않은 경우를 제외하고 리턴
        return answer - 1
    }
}