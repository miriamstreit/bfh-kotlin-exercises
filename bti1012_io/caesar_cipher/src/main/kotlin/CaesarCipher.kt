import java.io.InputStreamReader

class CaesarCipher(val key : Int) {
    val alphabet = "abcdefghijklmnopqrstuvwxyz"

    fun encrypt(text : String) : String {
        val input = text.toLowerCase().toCharArray()
        val output = StringBuffer()

        input.forEach { letter ->
            run {
                val i = alphabet.indexOf(letter)
                var newIndex = i+key
                if (newIndex > alphabet.length) newIndex -= alphabet.length
                if (i != -1) output.append(alphabet[newIndex])
                else output.append(letter)
            }
        }

        return output.toString()
    }

    fun decrypt(text : String) : String {
        val input = text.toLowerCase().toCharArray()
        val output = StringBuffer()

        input.forEach { letter ->
            run {
                val i = alphabet.indexOf(letter)
                var newIndex = i-key
                if (newIndex < 0) newIndex += alphabet.length
                if (i != -1) output.append(alphabet[newIndex])
                else output.append(letter)
            }
        }

        return output.toString()
    }
}

fun main() {
    val caesarCipher = CaesarCipher(7)
    val rawText = "Ich bin Caesar und verschluessle gerne"
    val encrypted = caesarCipher.encrypt(rawText);
    val decrypted = caesarCipher.decrypt(encrypted);

    println("raw text: $rawText\t encrypted text: $encrypted\t decrypted text: $decrypted")
}