fun main() {
    val size = readln().toInt()
    val list = IntArray(size) {
        readln().toInt()
    }
    for (i in list.indices) {
        var temp: Int
        for (j in 0..<i) {
            if (list[i] < list[j]) {
                temp = list[i]
                list[i] = list[j]
                list[j] = temp
            }
        }
    }

    list.forEach {
        println(it)
    }
}