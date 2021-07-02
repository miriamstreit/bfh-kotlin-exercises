object SumKotlin {
    @JvmStatic
    fun main(args: Array<String>) {
        var sum = 0
        for (arg in args) {
            sum += Integer.valueOf(arg)
        }
        println("The sum is $sum.")
    }
}