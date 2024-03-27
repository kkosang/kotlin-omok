package omok.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BoardTest {
    private lateinit var board: Board
    private lateinit var blackStone: Stone
    private lateinit var whiteStone: Stone

    private fun createBoard(stones: List<Stone>) {
        stones.forEach { stone ->
            board.putStone(stone)
        }
    }

    @BeforeEach
    fun setUp() {
        board = Board(Stones())
        blackStone = Stone(black, COORDINATE_F8)
        whiteStone = Stone(white, COORDINATE_F8)
    }

    @Test
    fun `오목판을 생성하면 기본적으로 15 x 15 사이즈를 갖는다`() {
        assertThat(board.width).isEqualTo(15)
        assertThat(board.height).isEqualTo(15)
    }

    @Test
    fun `오목판의 사이즈를 정해서 생성할 수 있다`() {
        val newBoard = Board(Stones(), 30, 30)
        assertThat(newBoard.width).isEqualTo(30)
        assertThat(newBoard.height).isEqualTo(30)
    }

    @Test
    fun `오목판은 착수된 돌을 가지고 있다`() {
        board.putStone(blackStone)
        assertThat(board.stones.stones).contains(blackStone)
    }

    /*
     12 [ ] [ ] [ ] [ ] [ ]
     11 [ ] [ ] [ ] [ ] [ ]
     10 [ ] [ ] [●] [ ] [ ]
      9 [ ] [ ] [●] [ ] [ ]
      8 [●] [●] [X] [ ] [ ]
         D   E   F   G   H
     */
    @Test
    fun `흑 플레이어가 3-3을 만드는 경우, 착수할 수 없다`() {
        createBoard(samSamBlackStones)

        val stoneState = board.putStone(blackStone)

        assertThat(stoneState).isEqualTo(StoneState.FailedPlaced("금수를 두었습니다."))
    }

    /*
     12 [ ] [ ] [ ] [ ] [ ]
     11 [ ] [ ] [ ] [●] [ ]
     10 [ ] [ ] [ ] [●] [ ]
      9 [ ] [ ] [ ] [●] [ ]
      8 [●] [●] [●] [X] [ ]
         C   D   E   F   G
    */
    @Test
    fun `흑 플레이어가 4-4을 만드는 경우, 착수할 수 없다`() {
        createBoard(fourFourBlackStones)

        val stoneState = board.putStone(blackStone)

        assertThat(stoneState).isEqualTo(StoneState.FailedPlaced("금수를 두었습니다."))
    }

    /*
      10 [ ] [ ] [ ] [●] [ ]
       9 [ ] [ ] [ ] [●] [ ]
       8 [ ] [ ] [ ] [X] [ ]
       7 [ ] [ ] [ ] [●] [ ]
       6 [ ] [ ] [ ] [●] [ ]
       5 [ ] [ ] [ ] [●] [ ]
          C   D   E   F   G
    */
    @Test
    fun `흑 플레이어가 장목을 만드는 경우, 착수할 수 없다`() {
        createBoard(moreThanFiveBlackStones)

        val stoneState = board.putStone(blackStone)

        assertThat(stoneState).isEqualTo(StoneState.FailedPlaced("금수를 두었습니다."))
    }

    /*
      11 [ ] [ ] [ ] [●] [ ]
      10 [ ] [ ] [ ] [●] [ ]
       9 [ ] [ ] [ ] [ ] [ ]
       8 [ ] [ ] [ ] [X] [ ]
       7 [ ] [ ] [ ] [●] [ ]
       6 [ ] [ ] [ ] [●] [ ]
       5 [ ] [ ] [ ] [ ] [ ]
       4 [ ] [ ] [ ] [●] [ ]
          C   D   E   F   G
     */
    @Test
    fun `흑 플레이어가 열린 4-4을 만드는 경우, 착수할 수 없다`() {
        createBoard(openFourFourBlackStones)

        val stoneState = board.putStone(blackStone)

        assertThat(stoneState).isEqualTo(StoneState.FailedPlaced("금수를 두었습니다."))
    }

    @Test
    fun `백 플레이어는 렌주룰을 적용받지 않는다`() {
        createBoard(samSamWhiteStones)

        val stoneState = board.putStone(whiteStone)

        assertThat(stoneState).isEqualTo(StoneState.SuccessfulPlaced)
    }
}
