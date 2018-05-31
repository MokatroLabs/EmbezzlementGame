 

import java.util.ArrayList;
/**
 * Write a description of class Deck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Deck
{
    private ArrayList<Card> deck;
    
    public Deck(){
        deck = new ArrayList<Card>();
    }
    public void createDeck()
    {
        deck.add(new Card("15 Minute Labor Break","+1R",1));
    }
}
