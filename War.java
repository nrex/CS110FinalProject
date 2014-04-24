import java.util.ArrayList;

public class War 
{
   private Deck warDeck;
   private ArrayList<Card> player;
   private ArrayList<Card> computer;
   private int round_count; //a counter for info
   private int HALF = 26;
   private Card temp_card;
   
   public War() throws NullPointerException
   {
      warDeck = new Deck();
      warDeck.shuffle();
      player = new ArrayList<Card>(HALF);
      computer = new ArrayList<Card>(HALF);
            
      for (int i = 0; i<HALF; i++)
      {
         temp_card = warDeck.dealCard();
         player.add(temp_card);
      }  
      
      for (int i = 0; i<HALF; i++)
      {
         temp_card = warDeck.dealCard();
         computer.add(temp_card);
      }  
      
      round_count = 0;
   }//war constructor
   
   public boolean round()
   {
   return true;
   }//round 
   
   public static void displayDeck(Deck d)
   {
      int i = 0;
      while (!(d.isEmpty()))
         System.out.println(i++ + " : " + d.dealCard().toString());
   }
   
   public static void main(String[] args) throws NullPointerException
   {
   
   War warGame = new War();
   //System.out.println(warGame.warDeck.isEmpty());
   System.out.println(warGame.player.size());
   System.out.println(warGame.computer.size());
   
   
   }//main





  



}//public class 