fun main() {
    // 테스트 케이스 개수 입력
    val t = readln().toInt()

    repeat(t) {
        // 10개의 숫자를 입력받아 리스트로 변환
        val numbers = readln().split(" ").map { it.toInt() }

        // 내림차순으로 정렬하고 3번째(인덱스 2) 숫자 출력
        val thirdLargest = numbers.sortedDescending()[2]
        println(thirdLargest)
    }
}