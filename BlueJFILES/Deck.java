 

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
        deck.add(new Card("Clown fiesta", "lose 1 rep and lose 200 dollars", 8));
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
        deck.add(new Card("Summon the heroes", "lose 3 rep", 19));
        deck.add(new Card("We're over it", "gain 1 rep", 20));
        deck.add(new Card("Watch DCI", "gain 2 rep, lose 200 dollars", 21));
        deck.add(new Card("Drum major", "gain 2 rep", 22));
        deck.add(new Card("Assistant Drum Major", "lose 3 rep", 23));
        deck.add(new Card("Power to Cerritos", "gain 4 rep", 24));
        deck.add(new Card("Section Leader", "gain 1 rep", 25));
        deck.add(new Card("Equipment Manager", "lose 2 rep", 26));
        deck.add(new Card("Interviewed by reporter", "gain 3 reps", 27));
        deck.add(new Card("Why did you assume?", "get audited", 28));
        deck.add(new Card("Brass Captain", "gain 3 rep", 29));
        deck.add(new Card("That's a safety hazard", "if you embezzle next turn, increase the amount by 10%, and assume the risks of doing so.", 30));
        deck.add(new Card("Blame the judges", "lose 3 reps and 500 dollars", 31));
        deck.add(new Card("Found wallet on the floor and turned it into the police", "gain 1 rep", 32));
        deck.add(new Card("4th place","lose 3 rep", 33));
        deck.add(new Card("Invest in Moshi", "gain 2500 dollars", 34));
        deck.add(new Card("Cut the BS", "reduce your cooldown by 1 turn",35));
        deck.add(new Card("Sashay Away", "reduce your cooldown by 2 turns", 36));
        deck.add(new Card("Ankush solo", "lose 2 rep", 37));
        deck.add(new Card("Liam solo", "gain 3 rep", 38));
        deck.add(new Card("Sprouts", "gain 2000 dollars, lose 1 rep", 39));
        deck.add(new Card("Volunterring at homeless shelter", "gain 2 rep", 40));
        deck.add(new Card("Went on a vacation and lose your wallet", "lose 600 dollars", 41));
        deck.add(new Card("Run into a judge", "gain 3 rep", 42));
        deck.add(new Card("Got sick and took a while to recover", "lose 200 dollars", 43));
        deck.add(new Card("Payday", "gain 300 dollars", 44));
        deck.add(new Card("Broke an instrument", "lose 700 dollars",45));
        deck.add(new Card("trailer", "in 4 turns, gain 1000 dollars", 46));
        deck.add(new Card("Bandroom locked", "lose 2 rep", 47));
        deck.add(new Card("Guuurrrrllllll", "lose 2 rep", 48));
        deck.add(new Card("You car was stolen", "lose 1000 dollars", 49));
        deck.add(new Card("Fettuccine", "gain 2 rep", 50));
        deck.add(new Card("Birth of a new child", "gain 1 rep, lose 400 dollars", 51));
        deck.add(new Card("Roll call", "lose 3 reps", 52));
        deck.add(new Card("Reuse props", "lose 5 rep, gain 2000 dollars", 53));
        deck.add(new Card("T-Helicopter", "gain 1500 dollars", 54));
        deck.add(new Card("Trostmobile", "gain 2 rep", 55));
        deck.add(new Card("Don't react", "increase your cooldwon by 1", 56));
        
        
        
        
    }
}
