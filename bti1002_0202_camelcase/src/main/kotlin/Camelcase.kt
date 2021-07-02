fun main(args : Array<String>) {
    convertToCamelcase(args[0])
}

fun convertToCamelcase(str: String) {
    val lowerString = str.toLowerCase().toCharArray()
    for(i in lowerString.indices step 2) {
        lowerString[i] = lowerString[i].toUpperCase();
    }
    var newString = ""
    lowerString.map { i -> newString.plus(i)}
    println(lowerString)
}