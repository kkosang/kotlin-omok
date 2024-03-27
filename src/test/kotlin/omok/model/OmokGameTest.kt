package omok.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OmokGameTest {
    private lateinit var players: Pair<Player, Player>
    private lateinit var board: Board

    @BeforeEach
    fun setUp() {
        players = Player(Color.BLACK) to Player(Color.WHITE)
        board = Board(Stones(fourFourBlackStones))
        board.putStone(Stone(Color.BLACK, COORDINATE_F12))
    }

    @Test
    fun `현재 오목 게임이 진행중인 상태라면 true를 반환한다`() {
        val omokGame = OmokGame(board)

        val expected = omokGame.isRunning()

        assertThat(expected).isTrue()
    }

    @Test
    fun `플레이어가 착수 할 수 있는 위치에 돌을 놓았다면, 돌의 상태는 보드에 놓일 수 있는 상태다`() {
        val omokGame = OmokGame(board)

        val stoneState = omokGame.playTurn(players.first, COORDINATE_F4)

        assertThat(stoneState).isEqualTo(StoneState.SuccessfulPlaced)
    }

    // 이미 돌이 놓여진 자리에 돌을 넣는 경우
    @Test
    fun `흑 플레이어가 이미 돌이 놓여진 자리에 돌을 놓았다면, 돌의 상태는 보드에 놓일 수 없는 상태다`() {
        val omokGame = OmokGame(board)

        val stoneState = omokGame.playTurn(players.first, COORDINATE_F10)

        assertThat(stoneState).isEqualTo(StoneState.FailedPlaced("이미 돌이 착수된 위치입니다."))
    }

    @Test
    fun `플레이어턴에 오목을 만들었다면 게임의 상태가 finish로 바뀌어야 한다`() {
        val omokGame = OmokGame(board)

        omokGame.playTurn(players.first, COORDINATE_F13)
        val expected = omokGame.isRunning()

        assertThat(expected).isFalse()
    }
}