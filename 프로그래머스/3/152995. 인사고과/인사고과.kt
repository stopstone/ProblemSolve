class Solution {
    fun solution(scores: Array<IntArray>): Int {
        val wanho = scores[0]
        val wanhoScore = wanho[0] + wanho[1]

        scores.sortWith(compareBy({ -it[0] }, { it[1] }))

        var maxPeer = -1
        val validScores = mutableListOf<Pair<Int, Boolean>>() // (sum, isWanho)

        for (score in scores) {
            val (a, b) = score
            if (b < maxPeer) {
                if (score.contentEquals(wanho)) return -1
                continue
            }

            maxPeer = maxOf(maxPeer, b)
            val isWanho = score.contentEquals(wanho)
            validScores.add(a + b to isWanho)
        }

        validScores.sortByDescending { it.first }

        var rank = 1
        var prevSum = -1
        var sameCount = 0

        for ((sum, isWanho) in validScores) {
            if (sum != prevSum) {
                rank += sameCount
                sameCount = 1
                prevSum = sum
            } else {
                sameCount++
            }

            if (isWanho) return rank
        }

        return -1
    }
}
