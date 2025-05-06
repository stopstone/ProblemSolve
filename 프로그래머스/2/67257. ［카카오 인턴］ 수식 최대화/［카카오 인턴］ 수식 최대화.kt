import kotlin.math.abs

class Solution {
    fun solution(expression: String): Long {
        val operators = listOf("+", "-", "*").filter { expression.contains(it) }
        val permutations = operators.permutations()

        val tokens = mutableListOf<String>()
        var num = ""
        for (c in expression) {
            if (c.isDigit()) {
                num += c
            } else {
                tokens.add(num)
                num = ""
                tokens.add(c.toString())
            }
        }
        tokens.add(num)

        var maxResult = 0L
        for (priority in permutations) {
            val result = abs(evaluate(tokens, priority))
            maxResult = maxOf(maxResult, result)
        }

        return maxResult
    }

    private fun evaluate(tokens: List<String>, priority: List<String>): Long {
        var tempTokens = tokens.toMutableList()

        for (op in priority) {
            val stack = mutableListOf<String>()
            var i = 0
            while (i < tempTokens.size) {
                val token = tempTokens[i]
                if (token == op) {
                    val prev = stack.removeLast().toLong()
                    val next = tempTokens[i + 1].toLong()
                    val res = when (op) {
                        "+" -> prev + next
                        "-" -> prev - next
                        "*" -> prev * next
                        else -> 0L
                    }
                    stack.add(res.toString())
                    i += 2
                } else {
                    stack.add(token)
                    i++
                }
            }
            tempTokens = stack
        }

        return tempTokens[0].toLong()
    }

    private fun <T> List<T>.permutations(): List<List<T>> {
        if (this.size <= 1) return listOf(this)
        val result = mutableListOf<List<T>>()
        for (i in this.indices) {
            val rest = this.toMutableList().apply { removeAt(i) }
            for (perm in rest.permutations()) {
                result.add(listOf(this[i]) + perm)
            }
        }
        return result
    }
}
