import java.util.*

class Solution {
    fun solution(s: String): String {
        val words = s.split(" ")
        val result = mutableListOf<String>()

        words.forEach {
            if (it.isEmpty()) {
                result.add("")
                return@forEach
            }
            val firstChar = it.first().uppercaseChar()
            val otherString = if (it.length > 1) it.substring(1) else ""

            val word = firstChar + otherString.lowercase(Locale.getDefault())
            result.add(word)
        }
        return result.joinToString(" ")
    }
}


fun main() {
    println(Solution().solution("  for the what  1what  "))
}