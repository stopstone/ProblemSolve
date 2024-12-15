
fun main() {
    var person = 0
    var max = 0
    repeat(10) {
        val (input, output) = readln().split(" ").map { it.toInt() }

        person -= input
        person += output

        if (max < person) {
            max = person
        }
    }

    print(max)
}