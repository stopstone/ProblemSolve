class Solution {
    fun solution(answers: IntArray): IntArray {
        val result = mutableListOf<Int>()

        // 수포자 삼인방의 찍는 패턴
        val patterns = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(2, 1, 2, 3, 2, 4, 2, 5),
            intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        )

        // 성적을 담을 배열
        val scores = IntArray(patterns.size)

        // 정답 채점
        for (i in answers.indices) {
            for (j in patterns.indices) {
                if (answers[i] == patterns[j][i % patterns[j].size]) {
                    scores[j]++
                }
            }
        }

        val maxScore = scores.maxOrNull()
        for (i in scores.indices) {
            if (scores[i] == maxScore) {
                result.add(i + 1)
            }
        }

        return result.toIntArray()
    }
}
