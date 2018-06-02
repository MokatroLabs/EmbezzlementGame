 

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
        deck.add(new Card("Bruul","at the end of each turn for 5 turns, gain +1rep/+100 dollars",1));
        deck.add(new Card("Got into a card accident", "lose 1000 dollars", 2));
        deck.add(new Card("Featured on a newspaper front cover", "gain 2 rep", 3));
        deck.add(new Card("Glacial pace", "increase your cooldowns by 2 turns", 4));
        deck.add(new Card("Gush and Go", "your next move is randomized", 5));
        deck.add(new Card("Did you just fart?", "lose 1 rep", 6));
        deck.add(new Card("Courtyard meeting", "silence next rehearsal(lose a turn)", 7));
        deck.add(new Card("Clow fiesta", "lose 1 rep and lose 200 dollars", 8));
        deck.add(new Card("Went on a losing spree when gambling in Las Vegas", "lose 3 reps and 500 dollars", 9)); 
        deck.add(new Card("Fair share", "all players pay 750 dollars to the middle", 10));
        deck.add(new Card("15 min labor break", "gain 3 rep", 11));
        deck.add(new Card("Instrument maintence","lose 800 dollars", 12));
        deck.add(new Card("Tax cut", "gain 400 dollars", 13));
        deck.add(new Card("Win the lottery", "gain 700 dollars", 14));
        deck.add(new Card("Cinquantasei", "lose 2 rep draw another card", 15));
        deck.add(new Card("Don't play the victim", "draw a card and give it to another player", 16));
        deck.add(new Card("Caught for DUI", "lose 4 reps", 17));
        deck.add(new Card("Caught for tax evasion", "lose 3 reps" , 18));
        
        
        
    }
}
