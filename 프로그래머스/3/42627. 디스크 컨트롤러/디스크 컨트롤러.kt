import java.util.PriorityQueue

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        val jobList = jobs.sortedBy { it[0] }.toMutableList()

        val waitingQueue = PriorityQueue<IntArray>(compareBy({ it[1] }, { it[0] }))
        var currentTime = 0
        var totalTurnaround = 0
        var jobIndex = 0
        var completedJobs = 0

        while (completedJobs < jobs.size) {
            while (jobIndex < jobList.size && jobList[jobIndex][0] <= currentTime) {
                waitingQueue.add(jobList[jobIndex])
                jobIndex++
            }

            if (waitingQueue.isNotEmpty()) {
                val (startTime, duration) = waitingQueue.poll()
                currentTime += duration
                totalTurnaround += currentTime - startTime
                completedJobs++
            } else {
                currentTime = jobList[jobIndex][0]
            }
        }

        return totalTurnaround / jobs.size
    }
}
