package evolution_simulator.elements

import evolution_simulator.utilities.Vector2d

abstract class AbstractElement() {

    abstract var position: Vector2d
    abstract var direction: MapDirection?

    open fun changeState() {}

}