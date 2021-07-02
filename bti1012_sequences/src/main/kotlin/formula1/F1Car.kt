package formula1

import kotlin.random.Random

class F1Car {
    val team = teams[Random.nextInt(teams.size)]
    val maxSpeed = 250 + Random.nextInt(50)
    val driver = F1Driver()

    companion object {
        val teams =
            arrayOf("Mercedes", "Ferrari", "Williams", "RedBull", "Renault", "Sauber")
    }

    override fun toString(): String {
        return "f1race.F1Car(team='$team', maxSpeed=$maxSpeed, driver=$driver)"
    }
}

class F1Driver {
    val lastName = names[Random.nextInt(names.size)]
    val firstName = ('A' + Random.nextInt(26)) + "."
    val age = Random.nextInt(20) + 20
    val racesWon = Random.nextInt(10)

    companion object {
        var names =
            arrayOf("Hamilton", "Rosberg", "Vettel", "Raikkonen", "Bottas", "Massa")
    }

    override fun toString(): String {
        return "f1race.F1Driver(lastName='$lastName', firstName='$firstName', age=$age, racesWon=$racesWon)"
    }
}

fun main() {
    val cars = generateSequence { F1Car () }.take(50).toList()

    val fastestCars = cars.asSequence().sortedByDescending { s -> s.maxSpeed }.take(3).map { c -> c.team }.toList()
    val avgSpeed = cars.asSequence().filter { c -> c.driver.racesWon > 8 }.map { c -> c.maxSpeed }.average()
    val worstDrivers = cars.asSequence().sortedByDescending { t -> t.driver.racesWon }.take(3).map{ c -> "${c.driver.firstName} ${c.driver.lastName}"}.toList()

    println(fastestCars)
    println(avgSpeed)
    println(worstDrivers)
}