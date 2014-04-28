//Nathaniel Rex
// The Deck class that was given to us by Jackie, no edits. 

import java.util.Random;
import java.util.ArrayList;

public class Deck
{

   final int CARDS_IN_DECK = 52;

   ArrayList<Card> deck;
   
   
   /**
   *the Deck constructor generates a 52 card deck.
   */
   public Deck()
   {
            freshDeck();
   }
   /**
   *the freshdeck method generates a new 52 card deck. 
      */
   public void freshDeck()
   {
      deck = new ArrayList<Card>(CARDS_IN_DECK);
      //System.out.println(deck.size());

      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
           deck.add(new Card(r,s));
         }
      }
     
   
   }
    /**
   *dealCard method removes a card from the top of the deck and returns it. 
   */
   
   
   
   
   public Card dealCard()
   {
      Card c = deck.remove(0);  //  remove it (returns removed object)
      return c;
   }
   public int cardsRemaining()
   {  
      return deck.size();
   }
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }
   /**
   *isEmpty method checks to see if the deck is empty and returns true if it is. 
   */
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
   // by rank only
   /**
   *the highCard method returns the highest card among a group of cards
   */
   public static Card highCard(Card...cards) 
   {
   
      Card high = cards[0];
      for (int i=1;i<cards.length;i++)
      {
         if (cards[i].getRank() > high.getRank())
         {
         
            high = cards[i];
         }
      }
      return high;
   
   }
}
