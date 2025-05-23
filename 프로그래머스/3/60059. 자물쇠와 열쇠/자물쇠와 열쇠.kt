class Solution {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val m = key.size
        val n = lock.size
        val newSize = n + 2 * (m - 1)
        val newLock = Array(newSize) { IntArray(newSize) }

        for (i in lock.indices) {
            for (j in lock[i].indices) {
                newLock[i + m - 1][j + m - 1] = lock[i][j]
            }
        }

        repeat(4) {
            for (x in 0 until newSize - m + 1) {
                for (y in 0 until newSize - m + 1) {
                    val copyLock = newLock.map { it.copyOf() }.toTypedArray()
                    for (i in 0 until m) {
                        for (j in 0 until m) {
                            copyLock[x + i][y + j] += key[i][j]
                        }
                    }

                    if (isUnlocked(copyLock, m - 1, n)) return true
                }
            }
            rotate(key)
        }

        return false
    }

    private fun isUnlocked(lock: Array<IntArray>, offset: Int, size: Int): Boolean {
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (lock[i + offset][j + offset] != 1) return false
            }
        }
        return true
    }

    private fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        val temp = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                temp[j][n - 1 - i] = matrix[i][j]
            }
        }
        for (i in 0 until n) {
            for (j in 0 until n) {
                matrix[i][j] = temp[i][j]
            }
        }
    }
}
