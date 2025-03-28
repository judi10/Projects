/**
 *The Player class should be able to represent the set of cards a player has in hand.
 * The player class must allow to take a card from the deck and put it in the hand, 
 * count the points of the cards in hand...
 **/
import java.util.ArrayList;

public class Player {
     private ArrayList<Card>  hand;   // The cards in the plyaer's hand.
 
     /*Constructor*/
 Player(){
       //VOTRE CODE VIENT ICI
       hand = new ArrayList<Card>();
    }  
 
 /*Accessor*/
 public ArrayList<Card> getHand() {
        //VOTRE CODE VIENT ICI
        return hand;
    }
 
 /**
     * Remove all cards from the hand, leaving it empty.
  */
    public void clear() {
       //VOTRE CODE VIENT ICI
       hand.clear();
    }

    /**
     * Add a card to the hand.  It is added at the end of the current hand.
     * @param card the non-null card to be added.
     * @throws NullPointerException if the parameter card is null.
     */
    public void add(Card card) {
        //VOTRE CODE VIENT ICI
        if (card == null) {
        throw new NullPointerException();
        }
        hand.add(card); // Ajoute la carte à la main du joueur 
        
    }

    /**
     * Remove a card from the hand, if present.
     * @param card the card to be removed.  If card is null or if the card is not in 
     * the hand, then nothing is done.
     */
    public void remove(Card card) {
        //VOTRE CODE VIENT ICI
        hand.remove(card);
    }

    /**
     * Remove the card in a specified position from the hand.
     * @param position the position of the card that is to be removed, where
     * positions are numbered starting from zero.
     * @throws IllegalArgumentException if the position does not exist in
     * the hand, that is if the position is less than 0 or greater than
     * or equal to the number of cards in the hand.
     */
    public void remove(int position) {
        //VOTRE CODE VIENT ICI
        if(position < 0 || position >= hand.size()) throw new IllegalArgumentException();
        else hand.remove(position);
    }

    /**
     * Returns the number of cards in the hand.
     */
    public int totalCards() {
        //VOTRE CODE VIENT ICI
        return hand.size();
    }

    /**
     * Gets the card in a specified position in the hand.  (Note that this card
     * is not removed from the hand!)
     * @param position the position of the card that is to be returned
     * @throws IllegalArgumentException if position does not exist in the hand
     */
    public Card getCard(int position) {
        //VOTRE CODE VIENT ICI
        if(position < 0 || position >= hand.size()) throw new IllegalArgumentException();
        else {
            return hand.get(position);
        }
    }

   /**
     * Computes and returns the total value of this hand in the game
     */
    public int getHandTotal () {

        //VOTRE CODE VIENT ICI
        int total = 0; // stock the total of the hand
        for(Card card : hand){
            if(card.getValue() == 1 || total + card.getValue() >= 21){
                total += 10; 
            }
            else if(card.getValue() > 10) total += 10; // add the value for Queen King & Jack card
            
            else total += card.getValue();  // add the default card value to total
           }

        return total;
    }  
    
    /**
     * Sorts the cards in the hand so that cards of the same color are
     * grouped together, and within a color the cards are sorted by value.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByColor() {
        //VOTRE CODE VIENT ICI
        int n = hand.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Card card1 = hand.get(j);
                Card card2 = hand.get(j + 1);

                if (card1.getColor() > card2.getColor() || (card1.getColor() == card2.getColor() && card1.getValue() > card2.getValue())) {
                     
                    hand.set(j, card2); // swap card
                    hand.set(j + 1, card1);
                }
            }
        }
    }

    /**
     * Sorts the cards in the hand so that cards of the same value are
     * grouped together.  Cards with the same value are sorted by color.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByValue() {
        //VOTRE CODE VIENT ICI
        int n = hand.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Card card1 = hand.get(j);
                Card card2 = hand.get(j + 1);

                if (card1.getValue() > card2.getValue() || (card1.getValue() == card2.getValue() && card1.getColor() > card2.getColor())) {
                    
                    hand.set(j, card2); // swap card
                    hand.set(j + 1, card1);
                }
            }
        }
    }
} 