fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }

    val lis = mutableListOf<Int>()

    for (num in arr) {
        if (lis.isEmpty() || lis.last() < num) {
            lis.add(num)
        } else {
            val idx = lowerBound(lis, num)
            lis[idx] = num
        }
    }

    println(lis.size)
}

fun lowerBound(list: List<Int>, target: Int): Int {
    var left = 0
    var right = list.size

    while (left < right) {
        val mid = (left + right) / 2
        if (list[mid] >= target) {
            right = mid
        } else {
            left = mid + 1
        }
    }

    return left
}
