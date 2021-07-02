fun main() {
    calculatePi_leibniz()
}

fun calculatePi_leibniz () : Float {
    var piQuarter : Float = 1F
    var plus = false
    for(i in 3..1000 step 2) {
        var fractionOfI : Float = (1/i).toFloat()
        if (plus) piQuarter.plus(fractionOfI)
        else piQuarter.minus(fractionOfI)
        plus = !plus
        println(piQuarter)
        println(fractionOfI)
    }
    println(piQuarter*4)
    print(Math.PI)
    return piQuarter * 4
//    PI/4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 - ...
}