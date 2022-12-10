package evolution_simulator.kernel

import evolution_simulator.map.IWorldMap
import evolution_simulator.utilities.Vector2d

/**
 * The interface responsible for being run simulation on.
 * Kernel allows setting up simulations, checking stats and manipulating data.
 * Integrates more specialised simulation elements' work
 * by organising turns, processing queries and propagating changes.
 * @author integraledelebesgue
 */
interface ISimulationKernel {

    /**
     * Checks if position is legal in context of current map.
     * If the position is not legal, tries to transform it using map's geometry.
     * @param position Position to be checked.
     * @return Unchanged position if valid,
     *         Transformed position if not valid and able to transform,
     *         null otherwise.
     */
    fun validatePosition(position: Vector2d): Vector2d?

    fun setMap(map: IWorldMap)

}