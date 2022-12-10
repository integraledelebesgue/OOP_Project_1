package evolution_simulator.elements.animals

import evolution_simulator.elements.Command

class Brain(private val animal: Animal) {

    private var step = 0;

    fun generateMove(): Command{
        return Command.values()[animal.getGenotype()[step++ % 8]]
    }

}