class StringIterator(private val input : String) : Iterator {
    var currentPosition = 0

    override fun hasNext(): Boolean {
        return input.length - 1 > currentPosition
    }

    override fun next(): Any {
        val returnValue = if (input.length > currentPosition) input[currentPosition] else ""
        currentPosition++
        return returnValue
    }

    override fun reset() {
        currentPosition = 0
    }

}