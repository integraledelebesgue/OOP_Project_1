package evolution_simulator.elements

enum class MapDirection {

    N,
    NE,
    E,
    SE,
    S,
    SW,
    W,
    NW;

    operator fun inc(): MapDirection {
        return values()[(this.ordinal + 1) % 8]
    }

    operator fun dec(): MapDirection {
        return values()[(this.ordinal - 1) % 8]
    }

}