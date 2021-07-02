package main.kotlin.binomial

class Binomial {
    var counterRec = 0
    var counterTailrec = 0

    fun binomialRec(n : Long, k : Long) : Long {
        counterRec++
        if (k > n) return 0L
        if (k == 0L || k == n) return 1L
        return binomialRec(n-1, k) + binomialRec(n-1, k-1)
    }

    tailrec fun binomialReal(n : Double, k : Double, acc : Double = 1.0) : Double {
        counterTailrec++
        if (k == 0.0) return 1.0
        if (k == 1.0) return n / k * acc
        return binomialReal(n - 1, k - 1, n/k * acc)
    }


}

fun main() {
    val b = Binomial()
    // (51, 25) dauert ca. 1sec
    val resultTailrec = b.binomialReal(51.0, 25.0)
    // (51, 25) dauert mind. 2h
    val resultRec = b.binomialRec(5L, 3L)
    println("Binomialkoeffizient von (51, 25): $resultRec, Iterationen: ${b.counterRec}")
    println("Binomialkoeffizient von (51, 25): $resultTailrec, Iterationen: ${b.counterTailrec}")
}
