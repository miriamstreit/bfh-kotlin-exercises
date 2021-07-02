import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {
    //Car1 has a consumption of 5.0 l /100km and a tank size of 50l. Car1 is initially filled up fully and drives then 100 km.
    //Car2 has a consumption of 3.0 l /100km and  a default tank size. Car2 is initially filled up with 20 l and drives 150 km.
    private val car1 = Car(5.0)
    private val car2 = Car(3.0)

    @Test
    fun testCar1() {
        // Arrange
        car1.fillTank(50.0)

        // Act
        car1.drive(100)

        // Arrange
        Assertions.assertEquals(car1.gasLevel, 45.0)
    }

    @Test
    fun testCar2() {
        // Arrange
        car2.fillTank(20.0)

        // Act
        car2.drive(150)

        // Arrange
        Assertions.assertEquals(car2.gasLevel, 15.5)
    }
}