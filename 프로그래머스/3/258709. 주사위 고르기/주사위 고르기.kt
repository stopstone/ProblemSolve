class Solution {
    lateinit var dices: Array<IntArray>
    var n = 0
    var half = 0
    var bestWinCount = -1
    var bestPick: List<Int> = listOf()

    fun solution(dice: Array<IntArray>): IntArray {
        dices = dice
        n = dice.size
        half = n / 2

        combination(0, mutableListOf())

        return bestPick.map { it + 1 }.sorted().toIntArray()
    }

    private fun combination(index: Int, picked: MutableList<Int>) {
        if (picked.size == half) {
            simulate(picked)
            return
        }
        if (index == n) return

        picked.add(index)
        combination(index + 1, picked)
        picked.removeAt(picked.size - 1)
        combination(index + 1, picked)
    }

    private fun simulate(aPicks: List<Int>) {
        val bPicks = (0 until n).filter { it !in aPicks }

        val aSums = getAllSums(aPicks)
        val bSums = getAllSums(bPicks)

        val sortedASums = aSums.sorted()
        val sortedBSums = bSums.sorted()

        var winCount = 0
        var bIndex = 0

        for (aSum in sortedASums) {
            while (bIndex < sortedBSums.size && sortedBSums[bIndex] < aSum) {
                bIndex++
            }
            winCount += bIndex
        }

        if (winCount > bestWinCount) {
            bestWinCount = winCount
            bestPick = aPicks.toList()
        }
    }

    private fun getAllSums(picks: List<Int>): List<Int> {
        var sums = listOf(0)
        for (pick in picks) {
            val newSums = mutableListOf<Int>()
            for (sum in sums) {
                for (face in dices[pick]) {
                    newSums.add(sum + face)
                }
            }
            sums = newSums
        }
        return sums
    }
}
