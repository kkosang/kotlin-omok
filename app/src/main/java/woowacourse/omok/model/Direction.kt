package woowacourse.omok.model

enum class Direction(
    val directionVectors: List<DirectionVector>,
) {
    HORIZONTAL(listOf(DirectionVector.LEFT, DirectionVector.RIGHT)),
    VERTICAL(listOf(DirectionVector.TOP, DirectionVector.BOTTOM)),
    LEFT_DIAGONAL(listOf(DirectionVector.LEFT_TOP, DirectionVector.RIGHT_BOTTOM)),
    RIGHT_DIAGONAL(listOf(DirectionVector.TOP_RIGHT, DirectionVector.BOTTOM_LEFT)),
}

enum class DirectionVector(
    val dx: Int,
    val dy: Int,
) {
    LEFT(0, -1),
    RIGHT(0, 1),
    TOP(1, 0),
    BOTTOM(-1, 0),
    LEFT_TOP(1, -1),
    RIGHT_BOTTOM(-1, 1),
    TOP_RIGHT(1, 1),
    BOTTOM_LEFT(-1, -1),
}
