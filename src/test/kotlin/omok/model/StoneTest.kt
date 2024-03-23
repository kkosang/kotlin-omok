package omok.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StoneTest {
    @ParameterizedTest
    @CsvSource("1,A", "13,F", "4,G")
    fun `돌은 위치와 색상을 가지고 있다`(
        x: Int,
        y: String,
    ) {
        val coordinate = Coordinate(PositionX(x), PositionY.from(y))
        val stone = Stone(Color.BLACK, coordinate)

        assertThat(stone.color).isEqualTo(Color.BLACK)
        assertThat(stone.coordinate).isEqualTo(coordinate)
    }
}
