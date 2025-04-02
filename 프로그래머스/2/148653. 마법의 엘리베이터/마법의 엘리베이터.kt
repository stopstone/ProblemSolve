class Solution {
    fun solution(
        storey: Int,
    ): Int {
        var num = storey
        var answer = 0
        
        while(num > 0) {
            val digit = num % 10
            val next = (num / 10) % 10
            

            when {
                digit < 5 -> {
                    answer += digit
                    num /= 10
                }
                digit > 5 -> {
                    answer += 10 - digit
                    num = (num / 10) + 1
                }
                digit == 5 -> {
                    if (next >= 5) {
                        answer += (10 - digit)
                        num = (num / 10) + 1
                    } else {
                        answer += digit
                        num /= 10
                    }
                }
            }
        }
        return answer
    }
}