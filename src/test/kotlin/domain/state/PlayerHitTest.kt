package domain.state

import domain.Dummy.CLOVER_TWO
import domain.Dummy.makeHandOfCards
import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PlayerHitTest {
    @Test
    fun `카드를 받고 카드의 합이 21초과이면 Bust를 반환한다`() {
        val playerHit = PlayerHit(makeHandOfCards(10, 10))
        val actual = playerHit.nextState(CLOVER_TWO)

        assertThat(actual).isInstanceOf(Bust::class.java)
    }

    @Test
    fun `카드를 받고 카드의 합이 21이하이면 Hit를 반환한다`() {
        val playerHit = PlayerHit(makeHandOfCards(10, 3))
        val actual = playerHit.nextState(CLOVER_TWO)

        assertThat(actual).isInstanceOf(PlayerHit::class.java)
    }

    @Test
    fun `profit함수를 호출하면 StateException이 발생한다`() {
        val playerHit = PlayerHit(makeHandOfCards(10, 3))
        val state = Stay(makeHandOfCards(10, 2))

        assertThrows<IllegalStateException> { playerHit.playerProfit(state, 0.0) }.shouldHaveMessage("아직 진행중입니다")
    }
}
