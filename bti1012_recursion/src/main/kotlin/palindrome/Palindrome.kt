import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

fun String.isPalindrome() : Boolean {
    val cleanString = this
        .replace(" ", "")
        .replace(".", "")
        .replace("'", "")
        .replace(",", "")
        .toLowerCase()
    val length = cleanString.length
    if (length <= 1) return true
    val first = cleanString[0]
    val last = cleanString[length-1]
    val rest = cleanString.removeRange(0, 1).removeRange(length-2, length-1)
    if (first == last) return rest.isPalindrome()
    return false
}

internal class PalindromeKtTest {

    @Test
    fun isPalindrome_trivial() {
        Assertions.assertTrue("".isPalindrome())
        Assertions.assertTrue("a".isPalindrome())
        Assertions.assertTrue("aa".isPalindrome())
        Assertions.assertTrue("a a".isPalindrome())
        Assertions.assertTrue("aba".isPalindrome())
        Assertions.assertTrue("ab a".isPalindrome())
        Assertions.assertFalse("abc".isPalindrome())
        Assertions.assertTrue(" ab , a.".isPalindrome())
        Assertions.assertFalse("abc".isPalindrome())
    }

    @Test
    fun isPalindrome_DE() {
        Assertions.assertTrue("Regallager".isPalindrome())
        Assertions.assertTrue("Reittier".isPalindrome())
        Assertions.assertTrue(" Ein Neger mit Gazelle zagt im Regen nie.".isPalindrome())
        Assertions.assertTrue("Erika feuert nur untreue Fakire.".isPalindrome())
    }

    @Test
    fun isPalindrome_FR() {
        Assertions.assertTrue("Un roc cornu".isPalindrome())
        Assertions.assertTrue("  L'ami naturel ? Le rut animal.".isPalindrome())
        Assertions.assertTrue("Engage le jeu que je le gagne.".isPalindrome())
    }

}