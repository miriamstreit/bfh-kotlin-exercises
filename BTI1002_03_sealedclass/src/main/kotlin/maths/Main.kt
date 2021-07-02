package maths

fun main() {
    println("Result1 : ${Add(4, 3).execute()}")
    println("Result2 : ${Multiply(4, Incr(3).execute()).execute()}")
    println("Result3 : ${Divide(4, 2).execute()}")
    println("Result4 : ${Subtract(4, 2).execute()}")
    println("Result4 : ${Neg(4).execute()}")
}