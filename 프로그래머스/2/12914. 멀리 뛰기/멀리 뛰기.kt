class Solution {
    fun solution(n: Int): Long {
        if(n == 1 || n == 2) return n.toLong()
    
        val jumpList = LongArray(n + 1)
        jumpList[1] = 1
        jumpList[2] = 2

        for (idx in 3..n) {
            jumpList[idx] = (jumpList[idx - 1] + jumpList[idx - 2]) % 1234567
        }
        return jumpList.last()
    }
}
