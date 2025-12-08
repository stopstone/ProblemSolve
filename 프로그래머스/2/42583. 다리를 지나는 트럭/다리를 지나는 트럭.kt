class Solution {
    fun solution(
        bridge_length: Int, // 트럭 수
        weight: Int, // 다리가 견딜 수 있는 무게
        truck_weights: IntArray, // 트럭 별 무게
    ): Int {
        // 다리 위 상태를 나타내는 bridge
        val bridge = ArrayDeque<Int>().apply {
            repeat(bridge_length) { add(0) }
        }

        var time = 0
        var currentWeight = 0
        var index = 0 // 다음 트럭 인덱스

        while (index < truck_weights.size) {
            time++

            // 다리 트럭 제일 앞칸 빠짐
            currentWeight -= bridge.removeFirst()
            val nextTruck = truck_weights[index]

            // 다음 트럭이 올라올 수 있는지 확인
            if (currentWeight + nextTruck <= weight) {
                // 트럭 올림
                bridge.addLast(nextTruck)
                currentWeight += nextTruck
                index++
            } else {
                // 못올리면 0 넣어서 시간만 흐르게 한다.
                bridge.addLast(0)
            }
        }
        return time + bridge_length


    }

}

fun main() {
    val solution = Solution().solution(
        2,
        10,
        intArrayOf(7, 4, 5, 6)
    )

    println(solution)
}