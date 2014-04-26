import java.util.ArrayList;

public class War 
{
   private Deck warDeck;
   private ArrayList<Card> player;
   private ArrayList<Card> computer;
   private ArrayList<Card> warPile;
   public int round_count; //a counter for info
   private int HALF = 26;
   private Card temp_card;
   private int war_var;

   
   public War() throws NullPointerException //constructor establishes the deck as well as both of the players
   {
      warDeck = new Deck(); //initialize the decks
      warDeck.shuffle(); //shuffle the deck
      player = new ArrayList<Card>(HALF); //create the player array list
      computer = new ArrayList<Card>(HALF); //create the computer array list
      warPile = new ArrayList<Card>(0); //create the empty warPile array list
            
      for (int i = 0; i<HALF; i++) //deal half of the cards to the player
      {
         temp_card = warDeck.dealCard();
         player.add(temp_card);
      }  
      
      for (int i = 0; i<HALF; i++) //deal half of the cards to the computer
      {
         temp_card = warDeck.dealCard();
         computer.add(temp_card);
      }  
      
      round_count = 0; //initialize the number of rounds
   }//war constructor
   
   public int playRound()//play a round of war
   {
      round_count+=1;//increase the round count
      Card temp_player_card = player.remove(0); 
      Card temp_computer_card = computer.remove(0);
      System.out.println("P: "+temp_player_card);
      System.out.println("C: "+temp_computer_card);
      System.out.println(player.size());
      System.out.println(computer.size());
      
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
         //System.out.println("Putting: " + temp_player_card + " back in player");
         //System.out.println("Putting: " + temp_computer_card + " back in computer");

         player.add(0, temp_player_card);
         computer.add(0, temp_computer_card);
         war_var = this.warRound();
         return 0;
      }
   }//end play round
     
      
      public int warRound()
      {
         System.out.println("War!");
         Card warCard;
         Card temp_player_card = player.remove(0);
         Card temp_computer_card = computer.remove(0);
         warPile.add(temp_player_card); //put the current cards into the pile
         warPile.add(temp_computer_card); //put the current cards into the pile
         temp_player_card = player.remove(0); //put the next card into the pile
         temp_computer_card = computer.remove(0); //put the next card into the pile
         warPile.add(temp_player_card); 
         warPile.add(temp_computer_card);
         
         //System.out.println(player.size());
         //System.out.println(computer.size());
         //System.out.println("WarPile Size: " +warPile.size());
         
         int war_winner = this.playRound(); //play a round to determine the winner.
         
         int warPileLength = warPile.size();
         if (war_winner == 2)
         {
            for (int i = 0; i < warPileLength;i++)
            {
               warCard = warPile.remove(0);
               player.add(warCard);
            }
         }//player won war
         
         else if (war_winner == 3)
         {
            for (int i = 0; i < warPileLength;i++)
            {
               warCard = warPile.remove(0);
               computer.add(warCard);
            }
         }//computer won war
         else 
         {
            if (war_var > 1) this.warRound();
            
         }//must play another round
         System.out.println(player.size());
         System.out.println(computer.size());
         war_var = 0;
         return 0;
      }//warRound method
   
   public static void main(String[] args) throws IndexOutOfBoundsException
   {
       int blah = 1;

      try
      {
         War warGame = new War();
         do
         {
            blah = warGame.playRound();
            System.out.println("Round: " + warGame.round_count);

         } while(true);
      } //try
      catch (IndexOutOfBoundsException e)
      {
         System.out.println("Game Over");
         if (blah==3) System.out.println("Computer Won");
         if (blah==2) System.out.println("Player Won");
         
      }//catch
      //warGame.warRound();

      
      //System.out.println("Round: " + warGame.round_count);
   }//main
}//public class 