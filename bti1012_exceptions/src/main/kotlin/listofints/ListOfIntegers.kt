package listofints

import java.io.*
import kotlin.system.exitProcess

private const val SIZE = 10

class ListOfIntegers {
    private var intList = ArrayList<Int>()

    /**
     * Initialize the intList object and fills it with Integers 0..9.
     */
    init {
        for (i in 0 until SIZE) {
            intList.add(i+1)
        }
    }

    /**
     * Outputs the formatted content of intList in the file OutFile.txt
     * @param fileName name of the output file
     */
    fun writeList(fileName: String) {
        var osw : OutputStreamWriter = try {
            OutputStreamWriter(FileOutputStream(fileName))
        } catch (fnfe : FileNotFoundException) {
            File(fileName).createNewFile()
            OutputStreamWriter(FileOutputStream(fileName))
        }

        osw.use { writer ->
            for ((idx,value) in intList.withIndex()) {
                writer.write("Value at: $idx = $value\n")
            }
        }
    }

    /**
     * Reads the content from the given file and adds ***all valid Integer values*** to the intList.
     * @param fileName name of the given file
     */
    fun readList(fileName: String) {
        try {
            InputStreamReader(FileInputStream(fileName)).use { reader ->
                reader.forEachLine { line ->
                    try {
                        intList.add(line.toInt())
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
}

/**
 * Main method.
 */
fun main() {
    val list = ListOfIntegers()
    list.readList("InFile.txt")
    list.writeList("OutFile.txt")
    println("Done !!")
}