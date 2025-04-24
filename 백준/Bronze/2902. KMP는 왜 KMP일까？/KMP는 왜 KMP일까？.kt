fun main() {
    var answer = ""
    readln().split("-").forEach {
        answer += it.first()
    }

    println(answer)
}
