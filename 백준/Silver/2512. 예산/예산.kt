import kotlin.math.max

fun main() {

    val n = readln().toInt()
    var max = 0
    val moneys = readln().split(" ").map {
        val money = it.toInt()
        max = max(max, money)
        return@map money
    }
    val m = readln().toInt()

    var left = 0
    var right = max
    var result = 0

    while (left <= right) {
        val mid = (left + right) / 2 // 상한액

        // 127
        var sumMoney = 0
        moneys.forEach { money ->
            if (money < mid) {
                sumMoney += money
            } else {
                sumMoney += mid
            }
        }

        if (sumMoney <= m) {
            result = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    println(result)
}
