class Solution {
    fun solution(s: String): Int {
        var count = 0

        for (i in s.indices) {
            val rotated = s.drop(i) + s.take(i)
            if (isValid(rotated)) {
                count++
            }
        }

        return count
    }

    private fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()
        val pairs = mapOf(')' to '(', ']' to '[', '}' to '{')

        for (ch in s) {
            if (ch in "([{") {
                stack.add(ch)
            } else if (ch in ")]}") {
                if (stack.isEmpty() || stack.removeAt(stack.size - 1) != pairs[ch]) {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }
}
