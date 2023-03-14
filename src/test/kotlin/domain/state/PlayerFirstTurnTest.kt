package domain.state

import domain.Dummy.CLOVER_ACE
import domain.Dummy.CLOVER_TEN
import domain.Dummy.CLOVER_TWO
import domain.Dummy.makeHandOfCards
import domain.card.HandOfCards
import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PlayerFirstTurnTest {
    @Test
    fun `두 장의 카드 합이 21이면 BlackJack을 반환한다`() {
        val actual = PlayerFirstTurn(HandOfCards()).nextState(CLOVER_ACE).nextState(CLOVER_TEN)

        assertThat(actual).isInstanceOf(BlackJack::class.java)
    }

    @Test
    fun `두 장의 카드 합이 21보다 작으면 Hit을 반환한다`() {
        val actual = PlayerFirstTurn(HandOfCards()).nextState(CLOVER_TWO).nextState(CLOVER_TEN)

        assertThat(actual).isInstanceOf(PlayerHit::class.java)
    }

    @Test
    fun `profit함수를 호출하면 StateException이 발생한다`() {
        val actual = PlayerFirstTurn(HandOfCards()).nextState(CLOVER_TWO).nextState(CLOVER_TEN)
        val state = Stay(makeHandOfCards(2, 10))

        assertThrows<IllegalStateException> { actual.playerProfit(state, 0.0) }.shouldHaveMessage("아직 진행중입니다")
    }
}
