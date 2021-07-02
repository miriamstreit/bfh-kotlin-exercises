/** Programming 2 with Kotlin - FS 19/20,
 *  Computer Science, Bern University of Applied Sciences */

package bytestream

import java.io.File

fun main() {
  File("src/main/kotlin/DisplayHex.kt").readBytes().forEachIndexed { index, byte ->
    print("%02X${if (index % 16 == 0) "\n" else " "}".format(byte))
  }
}