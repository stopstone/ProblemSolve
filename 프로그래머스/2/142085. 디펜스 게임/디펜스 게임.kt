import java.util.PriorityQueue

class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var soldiers = n
        var invincible = k

        val maxHeap = PriorityQueue<Int>(compareByDescending { it })

        for (i in enemy.indices) {
            val current = enemy[i]
            maxHeap.offer(current)
            soldiers -= current

            if (soldiers < 0) {
                if (invincible > 0) {
                    val max = maxHeap.poll()
                    soldiers += max
                    invincible--
                } else {
                    return i
                }
            }
        }

        return enemy.size
    }
}
