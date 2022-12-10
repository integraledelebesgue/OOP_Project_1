package evolution_simulator.utilities

import kotlin.math.abs
import kotlin.random.Random

class Vector2d(private val x: Int, private val y: Int) {

    operator fun plus(other: Vector2d): Vector2d {
        return Vector2d(this.x + other.x, this.y + other.y)
    }

    operator fun unaryMinus(): Vector2d {
        return Vector2d((-1) * this.x, (-1) * this.y)
    }

    fun isBounded(value: Int): Boolean{
        return abs(x) <= value && abs(y) <= value
    }

    override fun toString(): String{
        return "($x, $y)"
    }

    override fun hashCode(): Int {
        return x.hashCode() + 31 * y.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vector2d

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

}

fun randomVector(range: Int): Vector2d {
    return Vector2d(Random.nextInt(-range, range), Random.nextInt(-range, range))
}