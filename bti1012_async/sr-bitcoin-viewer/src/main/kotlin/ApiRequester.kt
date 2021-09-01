import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.net.URL

class ApiRequester() {

    /**
     * This function will call the given apiUrl and return the data as part of an expected DataClass (T)
     */
    inline fun <reified T> callUrl(url: String): T {
        val mapper = jacksonObjectMapper()

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        val json = URL(url).readText()

        return mapper.readValue(json, T::class.java)
    }

}