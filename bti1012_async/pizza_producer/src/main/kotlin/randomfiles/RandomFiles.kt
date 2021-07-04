import kotlinx.coroutines.*
import java.io.File

fun main() {
    runBlocking {
        val deferreds: List<Deferred<Int>> = (1..10).map {
            async {
                val f = File("file-$it.txt")
                val random = (0..1000)
                var sum = 0
                for(n in 0..99) {
                    val randomNumber = random.random()
                    sum += randomNumber
                    f.appendText(randomNumber.toString() + "\n")
                }
                f.appendText("$sum\n")
                sum
            }
        }
        val sums = deferreds.awaitAll()
        sums.forEach { println(it) }
    }
}