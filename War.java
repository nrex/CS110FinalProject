import java.util.ArrayList;

public class War 
{
   private Deck warDeck;
   private ArrayList<Card> player;
   private ArrayList<Card> computer;
   private ArrayList<Card> warPile;
   private int round_count; //a counter for info
   private int HALF = 26;
   private Card temp_card;
   
   public War() throws NullPointerException
   {
      warDeck = new Deck();
      warDeck.shuffle();
      player = new ArrayList<Card>(HALF);
      computer = new ArrayList<Card>(HALF);
      warPile = new ArrayList<Card>(0);
            
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
   
   public boolean playRound()
   {
      round_count+=1;
      Card temp_player_card = player.remove(0);
      Card temp_computer_card = computer.remove(0);
      System.out.println(temp_player_card);
      System.out.println(temp_computer_card);
      
      if (temp_player_card.getRank() > temp_computer_card.getRank())//player has higher card
      {  
         player.add(temp_player_card); //put the player's card back on the bottom
         player.add(temp_computer_card); //player won, so put the computer's card on the bottom
         System.out.println("Player Won");
      }
      else if (temp_player_card.getRank() < temp_computer_card.getRank()) //computer has higher card
      {
         computer.add(temp_computer_card);
         computer.add(temp_player_card);
         System.out.println("Computer Won");
      }
      else //war
      {
         warPile.add(temp_player_card);
         warPile.add(temp_computer_card);
         for (int i=0; i < 3;i++)
         {
            temp_player_card = player.remove(0);
            temp_computer_card = computer.remove(0);
            warPile.add(temp_player_card);
            warPile.add(temp_computer_card);
         }
         System.out.print("warPile:");System.out.println(warPile.size());
         return false;
      }
        
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
      do{
      warGame.playRound();
      } while (warGame.playRound());
      System.out.println(warGame.round_count);
      System.out.println(warGame.player.size());
      System.out.println(warGame.computer.size());
      
   
   
   }//main





  



}//public class 