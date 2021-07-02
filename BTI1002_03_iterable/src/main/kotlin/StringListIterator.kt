class StringListIterator(private val input : List<String>) : Iterator {
    private var currentPosition = 0

    override fun hasNext(): Boolean {
        return input.size - 1 > currentPosition
    }

    override fun next(): Any {
        val returnValue = input.get(currentPosition)
        currentPosition++
        return returnValue
    }

    override fun reset() {
        currentPosition = 0
    }

}