fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2..< n) {
        if (n % i == 0) return false
    }
    return true
}

fun main() {
    val m = readln().toInt()
    val n = readln().toInt()

    val primes = (m..n).filter { isPrime(it) }

    when(primes.isEmpty()) {
        true -> println(-1)
        false -> {
            println(primes.sum())
            println(primes.first())
        }
    }
}