package evolution_simulator.elements.plants

import evolution_simulator.elements.AbstractElement
import evolution_simulator.elements.MapDirection
import evolution_simulator.utilities.Vector2d

class Plant(position: Vector2d) : AbstractElement() {

    override var position: Vector2d = position
    override var direction: MapDirection? = null

}