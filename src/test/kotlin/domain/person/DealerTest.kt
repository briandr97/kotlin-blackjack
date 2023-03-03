package domain.person

import domain.card.Card
import domain.card.CardNumber
import domain.card.CardShape
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class DealerTest {

    private lateinit var dealer: Dealer

    @BeforeEach
    private fun setUp() {
        dealer = Dealer()
    }

    @Test
    fun `딜러는 이름을 가진다`() {
        assertThat(dealer.name).isEqualTo("딜러")
    }

    @Test
    fun `딜러는 카드를 받아서 패에 추가할 수 있다`() {
        dealer.receiveCard(Card(CardShape.HEART, CardNumber.ACE))
        assertThat(dealer.cards.size).isEqualTo(1)
    }

    @Test
    fun `딜러는 처음에 Hit 상태이다`() {
        assertThat(dealer.gameState).isEqualTo(GameState.HIT)
    }

    @CsvSource(value = ["ACE,TEN,21", "TWO,THREE,5"])
    @ParameterizedTest
    fun `카드 패의 총합을 계산한다`(number1: CardNumber, number2: CardNumber, sum: Int) {
        dealer.receiveCard(Card(CardShape.HEART, number1))
        dealer.receiveCard(Card(CardShape.HEART, number2))

        assertThat(dealer.getTotalCardNumber()).isEqualTo(sum)
    }

    @Test
    fun `딜러는 카드를 한 장만 보여준다`() {
        dealer.receiveCard(Card(CardShape.HEART, CardNumber.KING))
        dealer.receiveCard(Card(CardShape.HEART, CardNumber.QUEEN))
        val cards: List<Card> = dealer.showOneCard()

        assertThat(cards.size).isEqualTo(1)
    }

    @Test
    fun `딜러는 카드의 총합이 17이상이면 STAND 상태가 된다`() {
        dealer.receiveCard(Card(CardShape.HEART, CardNumber.KING))
        dealer.receiveCard(Card(CardShape.HEART, CardNumber.QUEEN))

        assertThat(dealer.gameState).isEqualTo(GameState.STAND)
    }
}
