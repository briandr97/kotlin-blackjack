package domain.state

import domain.card.Card
import domain.card.HandOfCards

interface State {
    val isFinished: Boolean
    val handOfCards: HandOfCards
    fun nextState(draw: () -> Card): State
    fun toStay(): State
    fun playerProfit(other: State, bet: Double): Double
}
