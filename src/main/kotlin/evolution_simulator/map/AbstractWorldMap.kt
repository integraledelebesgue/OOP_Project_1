package evolution_simulator.map

import evolution_simulator.elements.AbstractElement
import evolution_simulator.elements.animals.Animal
import evolution_simulator.elements.plants.Plant
import evolution_simulator.kernel.SimulationKernel
import evolution_simulator.utilities.Vector2d
import evolution_simulator.utilities.randomVector
import kotlin.jvm.Throws

abstract class AbstractWorldMap constructor() : IWorldMap {

    private var radius: Int = 10
    private var jungleRadius: Int = 1
    private var animals: HashMap<Vector2d, Animal> = HashMap()
    private var plants: HashMap<Vector2d, Plant> = HashMap()
    private lateinit var kernel: SimulationKernel

    @Throws(IllegalArgumentException::class)
    constructor(radius: Int, jungle_radius: Int, animals: Array<Animal>, plantsCount: Int) : this() {
        this.radius = radius
        this.jungleRadius =
            if(jungle_radius < radius)
                jungle_radius
            else
                throw(IllegalArgumentException("Jungle radius $jungle_radius cannot be greater than map radius $radius"))

        placeAnimals(animals)
    }

    @Throws(IllegalArgumentException::class)
    private fun placeAnimals(animals: Array<Animal>) {
        for(animal: Animal in animals)
            if(inBounds(animal.position))
                this.animals[animal.position] = animal  // Kernel assumes that all animals are to be placed correctly, no informing needed
            else
                throw(IllegalArgumentException("${animal.position} is not legal position to place animal."))
    }

    private fun placePlants(plantsCount: Int){
        var grown = 0

        while(grown < plantsCount){
            val positionToGrow: Vector2d = randomVector(radius)
            if(growPlant(positionToGrow)) {
                grown++
                informKernel(null, positionToGrow)
            }
        }
    }

    private fun growPlant(position: Vector2d): Boolean {
        if(getObjectAt(position) != null) return false

        plants[position] = Plant(position)
        return true
    }

    private fun informKernel(oldPosition: Vector2d?, newPosition: Vector2d) {
        // Change propagation chain: animal -> map -> kernel
        // Modify what is to modify and send the message higher
    }

    override fun getObjectAt(position: Vector2d): AbstractElement? {
        if(animals[position] != null) return animals[position] as AbstractElement
        if(plants[position] != null) return plants[position] as AbstractElement
        return null
    }

    override fun connectToKernel(kernel: SimulationKernel) {
        this.kernel = kernel
    }

    fun inBounds(vec: Vector2d): Boolean {
        return vec.isBounded(radius)
    }

    fun inJungle(vec: Vector2d):Boolean {
        return vec.isBounded(jungleRadius)
    }

    abstract override fun transformPosition(position: Vector2d): Vector2d?

}