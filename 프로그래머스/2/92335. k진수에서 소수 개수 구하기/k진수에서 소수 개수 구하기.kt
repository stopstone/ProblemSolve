class Solution {
    fun solution(n: Int, k: Int): Int {
        val converted = n.toString(k)
        val parts = converted.split("0")
        
        var count = 0
        
        for (part in parts) {
            if (part.isNotEmpty() && part.toLong().isPrime()) {
                count++
            }
        }
        
        return count
    }
}

// Long 타입의 확장 함수로 소수 판별
fun Long.isPrime(): Boolean {
    if (this < 2) return false
    for (i in 2..Math.sqrt(this.toDouble()).toLong()) {
        if (this % i == 0L) return false
    }
    return true
}
