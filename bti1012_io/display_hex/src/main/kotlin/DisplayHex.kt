import java.io.File
import java.io.FileInputStream

fun main() {
    FileInputStream(File("src/main/kotlin/DisplayHex.kt")).use { reader -> reader.readBytes().forEachIndexed {
        index, byte -> print("%02X${if (index % 16 == 0) "\n" else " " }".format(byte))
    } }
}