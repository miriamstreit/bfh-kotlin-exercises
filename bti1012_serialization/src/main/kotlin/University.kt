/** Programming 2 with Kotlin - FS 20/21,
 *  Computer Science, Bern University of Applied Sciences */
import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes(
    JsonSubTypes.Type(value = Student::class, name = "Student"),
    JsonSubTypes.Type(value = Professor::class, name = "Professor"),
    JsonSubTypes.Type(value = Employee::class, name = "Employee")
)
abstract class Person(val name: String = "unknown", val email: String = "unknown") {

    open val description: String
        @JsonIgnore
        get() = "A person with name: $name"

    override fun toString(): String {
        return "${this.javaClass.simpleName}: Name: $name, Email: $email"
    }
}

enum class Grade { A, B, C, D, E, F }

class Student(name: String, email: String, val grade: Grade) : Person(name, email) {
    override val description: String
        get() = "$name is a $grade grade student"

    override fun toString(): String {
        return super.toString() + ", Grade: $grade"
    }
}

class Professor(name: String, email: String, val subject: String) : Person(name, email) {
    override val description: String
        get() = "$name teaches $subject"

    override fun toString(): String {
        return super.toString() + ", Subject: $subject"
    }
}

class Employee(name: String, email: String, val department: String) : Person(name, email) {
    override val description: String
        get() = "Works in $department"

    override fun toString(): String {
        return super.toString() + ", Department: $department"
    }
}

@JacksonXmlRootElement(localName = "university")
data class University(
    val name: String = "unknown"
) {
    @JacksonXmlElementWrapper(localName = "staff")
    @JacksonXmlProperty(localName = "staffmember")
    val staff = ArrayList<Person>()
    @JacksonXmlElementWrapper(localName = "students")
    @JacksonXmlProperty(localName = "student")
    val students = ArrayList<Student>()

    fun addStudent(s: Student) {
        students.add(s)
    }

    fun addStaff(p: Person) {
        staff.add(p)
    }

    override fun toString(): String {
        return "${this.javaClass.simpleName}: name = $name, staff = $staff, students = $students"
    }


}

fun main() { // create some persons
    val student = Student("Max", "max@bfh.ch", Grade.B)
    val student2 = Student("Tom", "tom@bfh.ch", Grade.C)
    val prof = Professor("Mr. X", "prof.x@bfh.ch", "IT Security")
    val empl = Employee("Erni Schmidt", "erni.schmidt@bfh.ch", "HR")
    // create uni, assigning staff and students
    val bfh = University("bfh")
    bfh.addStaff(student)
    bfh.addStaff(prof)
    bfh.addStaff(empl)
    bfh.addStudent(student)
    bfh.addStudent(student2)

    writeXmlData(bfh)
    writeJsonData(bfh)
    val uni2 = readJsonData()
    println(uni2)
}

private const val jsonOutputFileName = "university.json"
private const val xmlOutputFileName = "university.xml"

private fun writeJsonData(uni: University) {
    val mapper = jacksonObjectMapper()
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    println("Write to file $jsonOutputFileName")
    try {
        FileOutputStream(jsonOutputFileName).use { out ->
            mapper.writerWithDefaultPrettyPrinter().writeValue(out, uni)
        }
    } catch (ex: IOException) {
        println(ex.printStackTrace())
    }
}

private fun writeXmlData(uni: University) {
    val mapper = XmlMapper()
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
    mapper.registerModule(JavaTimeModule())
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    println("Write to file $xmlOutputFileName")
    try {
        FileOutputStream(xmlOutputFileName).use { out ->
            mapper.writerWithDefaultPrettyPrinter().writeValue(out, uni)
        }
    } catch (ex: IOException) {
        println(ex.printStackTrace())
    }
}

private fun readJsonData(): University {
    val mapper = jacksonObjectMapper()
    println("Read from file $jsonOutputFileName")
    try {
        FileInputStream(jsonOutputFileName).use {
            return mapper.readValue(
                it, University::class.java
            ) as University
        }
    } catch (ex: IOException) {
        println(ex.printStackTrace())
    }
    return University()
}