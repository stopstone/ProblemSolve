fun main() {

    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.sorted()
    val m = readln().toInt()
    val b = readln().split(" ").map { it.toInt() }

    repeat(m) { index ->
        var left = 0
        var right = n - 1
        var isFind = false
        
        while (left <= right) {
            val mid = (left + right) / 2
            val currentNumber = a[mid]
            val answer = b[index]

            if (currentNumber == answer) {
                isFind = true
                break
            } else if (currentNumber < answer) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        if (isFind) {
            println(1)
        } else {
            println(0)
        }
    }

}