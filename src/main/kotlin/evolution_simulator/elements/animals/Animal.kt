package evolution_simulator.elements.animals

import evolution_simulator.elements.AbstractElement
import evolution_simulator.elements.MapDirection
import evolution_simulator.utilities.Vector2d

class Animal(override var position: Vector2d, override var direction: MapDirection?, var energy: Int, private val genotype: Genotype) : AbstractElement() {

    private val brain = Brain(this);

    fun getGenotype(): Genotype {
        return genotype;
    }

    override fun changeState() {
        // Retrieve command from Brain
        // Ask Kernel if command is legal
        // Change position and direction
        // Inform Kernel
    }

}