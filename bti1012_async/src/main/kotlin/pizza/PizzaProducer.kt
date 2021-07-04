package pizza

import kotlinx.coroutines.*

import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import java.util.concurrent.atomic.AtomicInteger

// helpful link: https://kotlinlang.org/docs/channels.html

data class PizzaOrder(val orderNumber: String, val waiter: String = "Default")

val orderNumberCounter = AtomicInteger(0)

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.produceOrders(waiter : String): ReceiveChannel<PizzaOrder> = produce {
    while(true) {
        repeat(10) {
            val order = PizzaOrder(orderNumberCounter.incrementAndGet().toString(), waiter)
            println("Producing order with ID ${order.orderNumber}")
            send(order)
        }
        delay(1000)
    }
}

// implemented following this guide: https://stackoverflow.com/a/56584509
@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.mergeChannels(vararg channels: ReceiveChannel<PizzaOrder>) : ReceiveChannel<PizzaOrder> {
    return produce {
        channels.forEach {
            launch { it.consumeEach { send(it) }}
        }
    }
}

fun CoroutineScope.processOrders(id: Int, channel: ReceiveChannel<PizzaOrder>) = launch {
    for (msg in channel) {
        println("Processor #$id received order with ID ${msg.orderNumber}")
    }
}

fun main() {
    runBlocking {
        val job = launch(Dispatchers.Default) {
            val pizzaProducer1 = produceOrders("Dominos")
            val pizzaProducer2 = produceOrders("Mamma Mia")

            val pizzaChannel = mergeChannels(pizzaProducer1, pizzaProducer2)

            repeat(3) {
                processOrders(it, pizzaChannel)
            }
        }
        delay(2000)
        println("Stopping")
        job.cancelAndJoin()
    }
}
