class DigitsIterator : Iterator {
    private val range = 0..9
    var currentVal = 0

    override fun hasNext(): Boolean {
        return range.contains(currentVal+1)
    }

    override fun next(): Any {
        val returnVal = currentVal
        currentVal++
        return returnVal
    }

    override fun reset() {
        currentVal = 0
    }

}