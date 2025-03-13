class Solution {
    private val words = mutableListOf<String>()
    private val vowels = listOf("A", "E", "I", "O", "U")

    fun solution(word: String): Int {
        generateWords()
        return words.indexOf(word) + 1
    }

    private fun generateWords(current: String = "") {
        if (current.length > 5) return
        if (current.isNotEmpty()) words.add(current)

        for (vowel in vowels) {
            generateWords(current + vowel)
        }
    }
}