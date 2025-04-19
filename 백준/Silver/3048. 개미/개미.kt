fun main() {
    val (n1, n2) = readln().split(" ").map { it.toInt() }
    val group1 = readln().toList().reversed()
    val group2 = readln().toList()
    val t = readln().toInt()

    val all = (group1 + group2).toMutableList()
    val isFromGroup1 = BooleanArray(all.size) { i -> i < n1 }

    repeat(t) {
        var i = 0
        while (i < all.size - 1) {
            if (isFromGroup1[i] && !isFromGroup1[i + 1]) {
                all[i] = all[i + 1].also { all[i + 1] = all[i] }
                isFromGroup1[i] = false
                isFromGroup1[i + 1] = true
                i += 2
            } else {
                i += 1
            }
        }
    }

    println(all.joinToString(""))
}
