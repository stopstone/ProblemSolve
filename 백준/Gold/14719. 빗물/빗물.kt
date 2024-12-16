fun main() {
    // 입력 받기
    val (h, w) = readln().split(" ").map { it.toInt() }
    val heights = readln().split(" ").map { it.toInt() }

    var totalWater = 0

    // 각 위치별로 고이는 물의 양 계산
    for (i in 1..<w-1) {
        // 현재 위치의 왼쪽에서 가장 높은 블록 찾기
        val leftMax = heights.subList(0, i).maxOrNull() ?: 0

        // 현재 위치의 오른쪽에서 가장 높은 블록 찾기
        val rightMax = heights.subList(i + 1, w).maxOrNull() ?: 0

        // 현재 위치에 고일 수 있는 물의 양 계산
        val waterLevel = minOf(leftMax, rightMax)

        // 현재 위치의 블록보다 수위가 높은 경우에만 물이 고임
        if (waterLevel > heights[i]) {
            totalWater += waterLevel - heights[i]
        }
    }

    // 결과 출력
    println(totalWater)
}