import kotlin.math.max

val tree = Array(27) {
    arrayOf(".", ".")
}

fun main() {
    val n = readln().toInt()
    repeat(n) {
        val input = readln().split(" ")

        tree[input[0].first().code - 'A'.code][0] = input[1]
        tree[input[0].first().code - 'A'.code][1] = input[2]
    }

    preOrder('A')
    println()
    inOrder('A')
    println()
    postOrder('A')
}

// 전위 순회
fun preOrder(c: Char) {
    if (c == '.') {
        return
    }

    print(c)
    preOrder(tree[c.code - 'A'.code][0].first())
    preOrder(tree[c.code - 'A'.code][1].first())
}

// 중위 순회
fun inOrder(c: Char) {
    if (c == '.') {
        return
    }
    inOrder(tree[c.code - 'A'.code][0].first())
    print(c)
    inOrder(tree[c.code - 'A'.code][1].first())
}

// 후위 순회
fun postOrder(c: Char) {
    if (c == '.') {
        return
    }
    postOrder(tree[c.code - 'A'.code][0].first())
    postOrder(tree[c.code - 'A'.code][1].first())
    print(c)
}