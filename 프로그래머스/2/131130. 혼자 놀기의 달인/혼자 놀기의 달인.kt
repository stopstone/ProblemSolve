class Solution {
    fun solution(cards: IntArray): Int {
        val visited = BooleanArray(cards.size)
        val groupSizes = mutableListOf<Int>()

        for (i in cards.indices) {
            if (visited[i]) continue

            var cnt = 0
            var idx = i
            while (!visited[idx]) {
                visited[idx] = true
                idx = cards[idx] - 1
                cnt++
            }

            groupSizes.add(cnt)
        }

        if (groupSizes.size < 2) return 0

        groupSizes.sortDescending()
        return groupSizes[0] * groupSizes[1]
    }
}
