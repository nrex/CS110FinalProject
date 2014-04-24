import java.util.ArrayList;

public class War
{
   private Deck warDeck;
   private ArrayList player;
   private ArrayList computer;
   private int round_count; //a counter for info
   private int HALF = 26;
   private Card temp_card;
   
   public War() 
   {
      warDeck = new Deck();
      warDeck.shuffle();
      
      player = new ArrayList<Card>(HALF);
      for (int i=0; i < HALF; i++)
      {
         temp_card = warDeck.dealCard();
         player.add(temp_card);
      }  
      
      computer = new ArrayList<Card>(HALF);
      for (int i=0; i < HALF; i++)
      {
         temp_card = warDeck.dealCard();
         player.add(temp_card);
      }  
      
      round_count = 0;
   }//war constructor
   
   public boolean round()
   {
   return true;
   }//round 
   
   public static void main(String[] args)
   {
   
   War warGame = new War();
   System.out.println(warGame.warDeck.isEmpty());
   System.out.println(warGame.player.size());
   System.out.println(warGame.computer.size());
   
   
   }//main



}//public class 