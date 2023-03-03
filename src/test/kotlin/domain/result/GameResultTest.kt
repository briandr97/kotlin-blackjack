package domain.result

import domain.card.Card
import domain.card.CardNumber
import domain.card.CardShape
import domain.person.Dealer
import domain.person.Player
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class GameResultTest {
    @Test
    fun `모든 사람의 승패를 결정한다`() {
        val players = listOf<Player>(
            Player("빅스").apply {
                receiveCard(Card(CardShape.HEART, CardNumber.TWO))
                receiveCard(Card(CardShape.DIAMOND, CardNumber.THREE))
                receiveCard(Card(CardShape.CLOVER, CardNumber.FOUR))
            },
            Player("베르").apply {
                receiveCard(Card(CardShape.CLOVER, CardNumber.ACE))
                receiveCard(Card(CardShape.SPADE, CardNumber.KING))
            },
        )
        val dealer = Dealer().apply {
            receiveCard(Card(CardShape.CLOVER, CardNumber.KING))
            receiveCard(Card(CardShape.SPADE, CardNumber.NINE))
        }
        val gameResult = GameResult(dealer, players)

        val expectedDealerResult = mapOf(OutCome.WIN to 1, OutCome.LOSE to 1)
        val expectedPlayersResult = mapOf("빅스" to OutCome.LOSE, "베르" to OutCome.WIN)

        assertAll(
            { assertThat(gameResult.getDealerResult()).isEqualTo(expectedDealerResult) },
            { assertThat(gameResult.getPlayerResult()).isEqualTo(expectedPlayersResult) },
        )
    }
}
