import kotlin.math.ceil

data class Parking(
    val time: Int,
    val carId: String,
    val parkingType: String,
)

class Solution {
    fun solution(
        fees: IntArray,
        records: Array<String>
    ): IntArray {
        val parkingMap = mutableMapOf<String, MutableList<Parking>>()

        val 기본시간 = fees[0]
        val 기본요금 = fees[1]
        val 단위시간 = fees[2]
        val 단위요금 = fees[3]

        // 차량번호 별 주차 정보
        records.forEach { record ->
            val parkingInfo = record.split(" ")
            val parking = Parking(
                time = parkingInfo[0].transferTimeFormat(),
                carId = parkingInfo[1],
                parkingType = parkingInfo[2],
            )
            parkingMap.putIfAbsent(parkingInfo[1], mutableListOf())
            parkingMap[parkingInfo[1]]?.add(parking)
        }

        // 출차가 없는 경우 23:59분 넣기
        parkingMap.keys.forEach { carId ->
            val records = parkingMap[carId] ?: mutableListOf()
            if (records.size % 2 == 1) {
                val outInfo = Parking(
                    carId = records.first().carId,
                    time = "23:59".transferTimeFormat(),
                    parkingType = "OUT",
                )
                records.add(outInfo)
            }
        }

        // 차량별 추가시간 계산하기
        val totalTimes = mutableMapOf<String, Int>()
        parkingMap.forEach { (carId, times) ->
            var inTime: Int? = null
            var totalTime = 0

            times.forEach { record ->
                if (record.parkingType == "IN") {
                    inTime = record.time // IN일 때 저장
                } else if (record.parkingType == "OUT" && inTime != null) {
                    totalTime += record.time - inTime!! // OUT - IN
                    inTime = null
                }
            }

            totalTimes[carId] = totalTime
        }

        // 요금 계산 (기본시간 이하라면 기본요금, 초과하면 추가 요금 계산)
        val feeMap = totalTimes.mapValues { (_, time) ->
            if (time <= 기본시간) {
                기본요금
            } else {
                기본요금 + ceil((time - 기본시간).toDouble() / 단위시간).toInt() * 단위요금
            }
        }

        return feeMap.toSortedMap().values.toIntArray()
    }

    // HH:MM 형태 시간을 변환하는 함수
    private fun String.transferTimeFormat(): Int {
        var (hour, minute) = this.split(":").map { it.toInt() }
        minute += hour * 60
        return minute
    }
}