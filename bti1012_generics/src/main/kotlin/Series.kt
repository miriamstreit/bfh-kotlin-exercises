import java.util.function.Predicate

class Series<V>(val initial : V, val update : (V) -> V, val condition : (V) -> Boolean) : Iterator<V> {
    private var nextValue = initial

    override fun hasNext(): Boolean {
       return condition(nextValue)
    }

    override fun next(): V {
        check(hasNext())
        val next = nextValue
        nextValue = update(nextValue)
        return next
    }

    fun reset() {
        nextValue = initial
    }

    fun toList(): List<V> {
        val list = ArrayList<V>()
        reset()
        while(hasNext()) {
            list.add(next())
        }
        return list
    }
}