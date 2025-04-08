class Solution {
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        val discounts = listOf(10, 20, 30, 40)
        var bestJoin = 0
        var bestRevenue = 0

        fun dfs(depth: Int, currentDiscounts: MutableList<Int>) {
            if (depth == emoticons.size) {
                // 할인율 조합 완성, 이제 계산 시작
                var joinCount = 0
                var revenue = 0

                for (user in users) {
                    val (minDiscount, priceLimit) = user
                    var total = 0
                    for (i in emoticons.indices) {
                        if (currentDiscounts[i] >= minDiscount) {
                            val discountedPrice = emoticons[i] * (100 - currentDiscounts[i]) / 100
                            total += discountedPrice
                        }
                    }
                    if (total >= priceLimit) {
                        joinCount++
                    } else {
                        revenue += total
                    }
                }

                if (joinCount > bestJoin || (joinCount == bestJoin && revenue > bestRevenue)) {
                    bestJoin = joinCount
                    bestRevenue = revenue
                }
                return
            }

            for (discount in discounts) {
                currentDiscounts.add(discount)
                dfs(depth + 1, currentDiscounts)
                currentDiscounts.removeAt(currentDiscounts.size - 1)
            }
        }

        dfs(0, mutableListOf())

        return intArrayOf(bestJoin, bestRevenue)
    }
}