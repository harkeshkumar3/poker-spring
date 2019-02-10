package be.kdg.gameservice.round.model;

import be.kdg.gameservice.UtilTesting;
import be.kdg.gameservice.card.Card;
import be.kdg.gameservice.card.CardType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public final class DeckTest extends UtilTesting {
    private Deck deck;

    @Before
    public void setup() {
        this.deck = new Deck();
    }

    @Test
    public void testImmutabilityAttributes() {
        testImmutabilityAttributes(Deck.class);
    }

    @Test
    public void testCardCount() {
       assertEquals(52, deck.getNumberOfCards());
    }

    @Test
    public void testShuffleDeck() {
        List<Boolean> samePlaces = new ArrayList<>();

        for (CardType card : CardType.values()) {
            Card deckCard = deck.getCard();
            samePlaces.add(card.equals(deckCard.type));
        }

        assertNotEquals(52, samePlaces.stream().filter(p -> p).count());
    }

    @Test
    public void testImmutabilityDeck() {
        testImmutabilityAttributes(Deck.class);
    }
}
