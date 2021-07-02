/** Programming 2 with Kotlin - FS 20/21,
 *  Computer Science, Bern University of Applied Sciences */

package students

import kotlin.random.Random
import kotlin.streams.toList

class Student {
    val firstName= firstNames[Random.nextInt(firstNames.count())]
    val lastName = lastNames[Random.nextInt(lastNames.count())]
    val semester = Random.nextInt(10) + 1
    val averageGrade = 5 * Random.nextDouble() + 1

    companion object {
        val firstNames = arrayOf("Tom", "Ben", "Joe", "Andy", "Pete", "Sam")
        val lastNames = arrayOf("Smith", "Miller", "Jordan", "Wright", "Bush")
    }

    override fun toString(): String {
        return "Student(firstName='$firstName', lastName='$lastName', semester=$semester, averageGrade=$averageGrade)"
    }
}

fun main() {
    val students = generateSequence { Student () }.take(20).toList()

    val studentsFiltered = students
        .asSequence()
        .filter{ s -> s.semester == 6}
        .map { s -> "${s.firstName} ${s.lastName.toUpperCase()}"}
        .sorted()
        .take(10)
        .toList()
        .joinToString(", ")
    val grades = students.asSequence().filter { s -> s.averageGrade >= 4 }.groupingBy { s -> s.semester}.eachCount()

    println(studentsFiltered)
    println(grades)
}
