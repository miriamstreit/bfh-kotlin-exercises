package geography

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.FileInputStream
import kotlin.streams.toList

data class SwissGeography(val name : String = "", val capital : Capital, val languages : ArrayList<String>, val area : Int = 0, val cantons : ArrayList<Canton>) {
    override fun toString() = "Name: $name, capital: $capital, languages: ${printList(languages)}, area: $area, cantons: ${printList(cantons)}"
}

data class Canton(val name: String = "", val abbreviation : String = "") {
    override fun toString() = "[name: $name, abbreviation: $abbreviation]"
}

data class Capital(val name : String = "") {
    override fun toString() = name
}

fun <T: Any> printList(list: ArrayList<T>): String {
    return list.stream().map{ it.toString() }.toList().joinToString(", ")
}

fun main() {
    val mapper = jacksonObjectMapper()
    val geography : SwissGeography = mapper.readValue(FileInputStream("geography.json"))
    println(geography.toString())
}
