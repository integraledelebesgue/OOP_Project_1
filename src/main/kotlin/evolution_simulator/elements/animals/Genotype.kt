package evolution_simulator.elements.animals

import java.time.LocalDate
import kotlin.random.Random

class Genotype
    @Throws(IllegalArgumentException::class)
    constructor(private val genes: Array<Int>)
{

    init {
        if(genes.size != 8) throw IllegalArgumentException("Gene count must equal 8, ${genes.size} was given.")
    }

    @Throws(IndexOutOfBoundsException::class)
    operator fun get(i: Int): Int {
        if(0 > i || i > 7) throw IndexOutOfBoundsException("Gene index must belong to {0, 1, ..., 7}, $i was given.")
        return genes[i]
    }

    companion object CrossBreeder {
        fun crossGenotypes(dominant: Genotype, recessive: Genotype, recessiveCount: Int): Genotype {
            var newGenes: Array<Int> = dominant.genes.copyOf()

            if((0..1).random() == 0)
                newGenes = newGenes.reversedArray()

            for(i in (dominant.genes.size - recessiveCount - 1 until dominant.genes.size))
                newGenes[i] = recessive.genes[i]

            return Genotype(newGenes)
        }
    }

}