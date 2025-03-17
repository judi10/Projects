
/**
 *  Deck represents a deck of playing cards and contains 52 regular cards.
 */
public class Deck {

    private Card[] deck;  // an array of 52 cards.  
    private int number;  //the number of cards that have been dealt from the deck

    /**
     * Constructs a regular 52-card poker deck.  Initially, the cards
     * are in a sorted order.  
     */
    public Deck() {
        //VOTRE CODE VIENT ICI
        int indexDeck = 0; // save thew index of the array
        deck = new Card[52];

        for(int i = 1; i<14; i++){
            for(int j = 0; j<4; j++){
                deck[indexDeck++] = new Card(i, j);
            }
        }
        number = 0; 
 }


    /**
     * Put all the used cards back into the deck (if any), and
     * shuffle the deck into a random order.
     */
    public void shuffle() {
        //VOTRE CODE VIENT ICI
        number = 0;

        for (int i = 0; i < deck.length; i++) {
        int randomIndex = (int) (Math.random() * deck.length); // choose a random index
        
        Card temp = deck[i];
        deck[i] = deck[randomIndex]; // Exchange deck[i] with deck[randomIndex]
        deck[randomIndex] = temp;
         
    }
    }

    /**
     * Returns the number of cards left in the deck.  
     */
    public int numberLeft() {
        //VOTRE CODE VIENT ICI
        return 52 - number;
    }

    /**
     * Removes the next card from the deck and return it.  It is illegal
     * to call this method if there are no more cards in the deck.  You can
     * check the number of cards remaining by calling the numberLeft() function.
     * @return the card which is removed from the deck.
     * @throws IllegalStateException if there are no cards left in the deck
     */
    public Card take() {
        //VOTRE CODE VIENT ICI
        Card saveCard; // variable to stock the last card of the Deck
        if(number == 52) {
            throw new IllegalStateException();
        }
        else {
            saveCard = deck[number];
            number++;
        }

        return saveCard;
    }
} // end class Deck
