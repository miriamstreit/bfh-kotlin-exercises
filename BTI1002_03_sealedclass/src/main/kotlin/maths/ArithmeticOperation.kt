package maths

sealed class ArithmeticOperation {
    abstract fun execute() : Int
}

class Add(val nr1 : Int, val nr2: Int) : ArithmeticOperation() {
    override fun execute(): Int {
        return nr1 + nr2
    }
}

class Subtract(val nr1 : Int, val nr2: Int) : ArithmeticOperation() {
    override fun execute(): Int {
        return nr1 - nr2
    }
}

class Multiply(val nr1 : Int, val nr2: Int) : ArithmeticOperation() {
    override fun execute(): Int {
        return nr1 * nr2
    }
}

class Divide(val nr1 : Int, val nr2: Int) : ArithmeticOperation() {
    override fun execute(): Int {
        return if (nr2 != 0) nr1 / nr2 else 0
    }
}

class Incr(val nr : Int) : ArithmeticOperation() {
    override fun execute(): Int {
        return nr+1
    }
}

class Decr(val nr : Int) : ArithmeticOperation() {
    override fun execute(): Int {
        return nr-1
    }
}

class Neg(val nr : Int) : ArithmeticOperation() {
    override fun execute(): Int {
        return nr*-1
    }
}
