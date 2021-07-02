class StringTableIterator(private var input: Array<Array<String>>) : Iterator {
    var currentPosition = 0
    var currentPositionWithinCurrentPosition = 0

    override fun hasNext(): Boolean {
        return input[currentPosition].size - 1 > currentPositionWithinCurrentPosition || input.size - 1 > currentPosition
    }

    override fun next(): Any {
        val returnValue = input[currentPosition][currentPositionWithinCurrentPosition]
        if (input[currentPosition].size - 1 == currentPositionWithinCurrentPosition) {
            currentPosition++
            currentPositionWithinCurrentPosition = 0
        } else currentPositionWithinCurrentPosition++
        return returnValue
    }

    override fun reset() {
        currentPosition = 0
        currentPositionWithinCurrentPosition = 0
    }
}