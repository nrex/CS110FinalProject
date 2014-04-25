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
   
   public int playRound()
   {
      round_count+=1;
      Card temp_player_card = player.remove(0);
      Card temp_computer_card = computer.remove(0);
      System.out.println("P: "+temp_player_card);
      System.out.println("C: "+temp_computer_card);
      
      if (temp_player_card.getRank() > temp_computer_card.getRank())//player has higher card
      {  
         player.add(temp_player_card); //put the player's card back on the bottom
         player.add(temp_computer_card); //player won, so put the computer's card on the bottom
         System.out.println("Player Won");
         return 2;
      }
      else if (temp_player_card.getRank() < temp_computer_card.getRank()) //computer has higher card
      {
         computer.add(temp_computer_card);
         computer.add(temp_player_card);
         System.out.println("Computer Won");
         return 3;
      }
      else //prepare to start war
      {  
         System.out.println("Putting: " + temp_player_card + " back in player");
         System.out.println("Putting: " + temp_computer_card + " back in computer");

         player.add(0, temp_player_card);
         computer.add(0, temp_computer_card);
         int what_is_this_var = this.warRound();
         return 0;
      }
   }//end play round
     
      
      public int warRound()
      {
         Card temp_player_card = player.remove(0);
         Card temp_computer_card = computer.remove(0);
         warPile.add(temp_player_card); //put the current cards into the pile
         warPile.add(temp_computer_card); //put the current cards into the pile
         temp_player_card = player.remove(0); //put the next card into the pile
         temp_computer_card = computer.remove(0); //put the next card into the pile
         warPile.add(temp_player_card);
         warPile.add(temp_computer_card);
         
         System.out.println(player.size());
         System.out.println(computer.size());
         System.out.println("WarPile Size: " +warPile.size());
         
         int war_winner = this.playRound();
         
         if (war_winner == 2) //if the player won war;
         {
            for (int i = 0; i < warPile.size();i++) //put all of the cards fro mthe pile into the payer's deck
               {
                  Card warCard = warPile.remove(0);
                  player.add(warCard);
               }//player won war
         }
         else if (war_winner == 3)
         {
            for (int i = 0; i < warPile.size();i++) //put all of the cards from the pile into the computer's deck
               {
                  Card warCard = warPile.remove(0);
                  computer.add(warCard);
               }//computer won war
         }
         else 
         {
            this.playRound();
         }//must play another round
         System.out.println(player.size());
         System.out.println(computer.size());
         return 0;
      }//warRound method
        
 
   
   public static void displayDeck(Deck d)
   {
      int i = 0;
      while (!(d.isEmpty()))
         System.out.println(i++ + " : " + d.dealCard().toString());
   }
   
   public static void main(String[] args) throws NullPointerException
   {
      int blah = 1;
      War warGame = new War();
      //System.out.println(warGame.warDeck.isEmpty());
      //System.out.println(warGame.player.size());
      //System.out.println(warGame.computer.size());
      do
      {
         blah = warGame.playRound();
      }
      while(blah!=0);
      System.out.println("Round: " + warGame.round_count);
      //System.out.println(warGame.player.size());
      //System.out.println(warGame.computer.size());
      
   
   
   }//main





  



}//public class 