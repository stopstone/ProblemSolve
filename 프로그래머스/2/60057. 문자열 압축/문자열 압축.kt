class Solution {
    fun solution(s: String): Int {
        if (s.length == 1) return 1

        var minLength = Int.MAX_VALUE

        for (step in 1..s.length / 2) {
            var compressed = StringBuilder()
            var prev = s.substring(0, step)
            var count = 1

            for (i in step until s.length step step) {
                val end = if (i + step <= s.length) i + step else s.length
                val sub = s.substring(i, end)

                if (sub == prev) {
                    count++
                } else {
                    if (count > 1) compressed.append("$count")
                    compressed.append(prev)
                    prev = sub
                    count = 1
                }
            }

            // 마지막 남은 것 처리
            if (count > 1) compressed.append("$count")
            compressed.append(prev)

            minLength = minOf(minLength, compressed.length)
        }

        return minLength
    }
}
