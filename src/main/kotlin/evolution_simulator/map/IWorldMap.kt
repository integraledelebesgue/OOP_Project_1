package evolution_simulator.map

import evolution_simulator.elements.AbstractElement
import evolution_simulator.kernel.SimulationKernel
import evolution_simulator.utilities.Vector2d

interface IWorldMap {

    /**
     * Retrieves object placed at a given position.
     * @param position The position to be checked.
     * @return Abstract Element or null if the position is not occupied.
     */
    fun getObjectAt(position: Vector2d): AbstractElement?


    /**
     * Links map to simulation kernel.
     * Allows partial simulations and changing world rules by changing kernel.
     * @param kernel The kernel to be linked to.
     * @return null
     */
    fun connectToKernel(kernel: SimulationKernel)

    /**
     * Transforms out of bounds position if map's geometry allows such transformation (e.g. toroidal map).
     * @param position The position to be transformed.
     * @return Transformed position if such exists, else null.
     */
    fun transformPosition(position: Vector2d): Vector2d?
}