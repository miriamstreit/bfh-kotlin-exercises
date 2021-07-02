class Car(val gasConsumption : Double) {
    var gasLevel : Double = 0.0

    fun fillTank(liters : Double) {
        gasLevel += liters
    }

    fun drive(distance : Int) {
        gasLevel -= (gasConsumption / 100) * distance
    }
}