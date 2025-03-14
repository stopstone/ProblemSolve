class Solution {
    fun solution(phone_number: String): String {
        var answer = ""

        val secret = phone_number.length - 4

        for (i in phone_number.indices) {

            if (i < secret) {
                answer += "*"
            } else {
                answer += phone_number[i]
            }
        }
        return answer
    }
}