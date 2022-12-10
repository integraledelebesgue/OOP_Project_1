package evolution_simulator.kernel

import evolution_simulator.map.IWorldMap
import evolution_simulator.modes.MapMode
import evolution_simulator.modes.MutationMode
import evolution_simulator.modes.PlantGrowthMode
import evolution_simulator.utilities.Vector2d
import kotlin.jvm.Throws

class SimulationKernel : ISimulationKernel{

    @Throws(IllegalArgumentException::class)
    constructor(
        mapWidth: Int,
        mapMode: MapMode,
        mapHeight: Int,
        plantsOnStart: Int,
        energyPerPlant: Int,
        plantGrowthMode: PlantGrowthMode,
        animalsOnStart: Int,
        energyOnStart: Int,
        energyToBreed: Int,
        breedCost: Int,
        minMutations: Int,
        maxMutations: Int,
        mutationMode: MutationMode,
        genomeLength: Int,
        behaviourMode: Int
    ) {
        if(plantsOnStart > mapWidth * mapHeight)
            throw(IllegalArgumentException("Number of plants $plantsOnStart cannot be higher than number of fields $mapWidth x $mapHeight."))

        if(animalsOnStart > mapWidth * mapHeight)
            throw(IllegalArgumentException("Number of animals $animalsOnStart cannot be higher than number of fields $mapWidth x $mapHeight."))

        if(minMutations < 0)
            throw(IllegalArgumentException("Minimal number of mutations cannot be negative ($minMutations given)."))

        if(maxMutations < 0)
            throw(IllegalArgumentException("Maximal number of mutations cannot be negative ($maxMutations given)."))

        if(maxMutations < minMutations)
            throw(IllegalArgumentException("Maximal number of mutations ($maxMutations) cannot be fewer than minimal ($minMutations)."))

        if(genomeLength <= 0)
            throw(IllegalArgumentException("Genome length must be positive ($genomeLength given)"))
    }

    override fun validatePosition(position: Vector2d): Vector2d? {
        TODO("Not yet implemented")
    }

    override fun setMap(map: IWorldMap) {
        TODO("Not yet implemented")
    }

}