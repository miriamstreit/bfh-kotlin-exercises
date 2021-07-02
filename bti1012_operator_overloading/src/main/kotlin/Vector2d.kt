import kotlin.math.pow
import kotlin.math.sqrt

data class Vector2d(val x : Double, val y : Double)

operator fun Vector2d.plus(v : Vector2d) : Vector2d {
    return Vector2d(x + v.x, y + v.y)
}

operator fun Vector2d.minus(v : Vector2d) : Vector2d {
    return Vector2d(x - v.x, y - v.y)
}

operator fun Vector2d.unaryMinus() : Vector2d {
    return Vector2d(-x, -y)
}

operator fun Vector2d.times(factor : Double): Vector2d {
    return Vector2d(factor * x, factor * y)
}

operator fun Double.times(v : Vector2d): Vector2d {
    return Vector2d(this * v.x, this * v.y)
}

operator fun Vector2d.times(v : Vector2d) : Double {
    return x * v.x + y * v.y
}

fun mag(v : Vector2d) : Double {
    return sqrt(v.x.pow(2) + v.y.pow(2))
}

fun cross(v1: Vector2d, v2 : Vector2d) : Double {
    return v1.x * v2.y - v1.y * v2.x
}