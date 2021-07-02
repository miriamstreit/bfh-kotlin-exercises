package sales

import java.io.FileReader
import java.sql.Time
import java.util.*

data class SalesRecords(val transaction_id : Int, val date : String, val time : String, val customer_id : Int, val department : String, val amount : Double)

fun main() {
    val parsedSales = FileReader("sales.csv")
        .readLines()
        .asSequence()
        .drop(1)
        .map {  fromTextLine(it) }
        .filter { true }
        .toList()

    val firstQuery = parsedSales.asSequence().filter { it!!.customer_id == 4 }.count()
    val secondQuery = parsedSales.asSequence().filter { it!!.department == "Grocery" }.maxByOrNull { it!!.amount }
    val thirdQuery = parsedSales.asSequence().filter { it!!.department == "Baby"}.sortedBy { it!!.amount }.take(3).toList()

    println(firstQuery)
    println(secondQuery)
    println(thirdQuery)

    val fourthQuery = parsedSales.asSequence().groupBy { it!!.department }.toSortedMap(compareBy{ it }).forEach{println("${it.key}: ${it.value.count()}, \t ${it.value.sumByDouble{it!!.amount}}")}
}

fun fromTextLine(line : String) : SalesRecords? {
    val bits = line.split(",")
    try {
        return SalesRecords(bits[0].toInt(), bits[1], bits[2], bits[3].toInt(), bits[4], bits[5].toDouble())
    } catch (e : Exception) {
        println("reading line failed with following error. skipping the line. ${e.stackTraceToString()}")
        return null
    }

}