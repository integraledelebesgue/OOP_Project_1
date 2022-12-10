package evolution_simulator

import evolution_simulator.utilities.Vector2d
import evolution_simulator.utilities.randomVector


fun main(args: Array<String>) {
    println("Arguments: ${args.joinToString()}")

    val vec1 = Vector2d(1, 1)
    val vec2 = randomVector(10)

    println(vec1)
    println(vec2)
    println(-vec1)
    println(vec1 + vec2)

}
