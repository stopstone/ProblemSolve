import kotlin.math.*

data class Pos(val r: Int, val c: Int)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val city = Array(n) { readln().split(" ").map { it.toInt() } }

    val houses = mutableListOf<Pos>()
    val chickens = mutableListOf<Pos>()

    for (i in 0 until n) {
        for (j in 0 until n) {
            when (city[i][j]) {
                1 -> houses.add(Pos(i, j))
                2 -> chickens.add(Pos(i, j))
            }
        }
    }

    var minDistance = Int.MAX_VALUE

    fun comb(start: Int, selected: List<Pos>) {
        if (selected.size == m) {
            var total = 0
            for (home in houses) {
                var dist = Int.MAX_VALUE
                for (chicken in selected) {
                    val d = abs(home.r - chicken.r) + abs(home.c - chicken.c)
                    dist = min(dist, d)
                }
                total += dist
            }
            minDistance = min(minDistance, total)
            return
        }

        for (i in start until chickens.size) {
            comb(i + 1, selected + chickens[i])
        }
    }

    comb(0, listOf())
    println(minDistance)
}
