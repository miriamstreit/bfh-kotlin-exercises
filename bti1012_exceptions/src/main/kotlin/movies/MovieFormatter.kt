package movies

import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.InputStreamReader
import java.lang.Exception
import kotlin.system.exitProcess

class MovieFormatter {
    var movies: MutableList<Movie> = ArrayList()

    fun readCsv(fileName : String) {
        try {
            InputStreamReader(FileInputStream(fileName)).use { reader ->
                reader.forEachLine { line ->
                    try {
                        val splitLine = line.split(",")
                        val movie = Movie(
                            getArrayValue(splitLine, 0).orEmpty(),
                            getArrayValue(splitLine, 1).orEmpty(),
                            getArrayValue(splitLine, 2).orEmpty()
                            //getArrayValue(splitLine, 3)!!.toInt()
                        )
                        movies.add(movie)
                    } catch (e: NumberFormatException) {
                        // do nothing, just go on
                    }
                }
            }
        } catch (fnfe : FileNotFoundException) {
            println("The input file could not be located. Stacktrace:")
            fnfe.printStackTrace()
            exitProcess(1)
        }
    }

    fun printFormatted() {
        print("ID\tTitle\tCountry\tYear\n")
        movies.forEach {
            print(it.toString())
        }
    }

    private fun getArrayValue(list : List<String>, index : Int) : String? {
        return try {
            val extractedValue = list[index]
            if (extractedValue != "") extractedValue
            else null
        } catch (e : Exception) {
            null
        }
    }
}

fun main() {
    val movieFormatter = MovieFormatter()
    movieFormatter.readCsv("src/main/resources/movies-1.csv")
    movieFormatter.readCsv("src/main/resources/movies-2.csv")
    movieFormatter.printFormatted()
}