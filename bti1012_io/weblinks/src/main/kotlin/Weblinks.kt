import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.URL
import java.util.regex.Pattern

fun main() {
    val siteContentBuffer = BufferedReader(InputStreamReader(URL("https://www.bfh.ch/").openStream()))
    val siteContentBuilder = StringBuilder()
    siteContentBuffer.lines().forEach{ siteContentBuilder.append(it) }

    val regex = Pattern.compile("href=\"(.*?)\"")
    val matcher = regex.matcher(siteContentBuilder.toString())
    val listOfUrls = mutableListOf<String>()

    while (matcher.find()) {
        listOfUrls.add(matcher.group())
    }

    listOfUrls.forEach { println(it) }
}