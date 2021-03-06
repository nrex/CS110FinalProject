/**
 * Creat a War instance using the Deck and Card Classes. 
 * A war game can be played using the .playRound() method.
 *
 * @Nathaniel Rex
 */


import java.util.ArrayList;




public class War 
{
   private Deck warDeck; //an instance of deck used before I split the deck.
   public ArrayList<Card> player; //player's cards
   public ArrayList<Card> computer; //computer's cards
   private ArrayList<Card> warPile; //used to collect cards during a war bout
   public int round_count; //a counter for info
   private int HALF = 26; //used to split the deck
   private Card temp_card; //temporary card object 
   private int war_var; 
   public int game_over = 0; //used to determine if the game has been won

/**
The War() constructor creates and splits a shufled deck for the player. 
*/  
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
   
   /**
   The playround method is the only method necessary to play the war game. The return variable is used to determin the status of the game. 
   */
   
   
   public int playRound()//play a round of war
   {
      round_count+=1;//increase the round count
      System.out.println(player.size());
      System.out.println(computer.size());
      Card temp_player_card = player.remove(0); 
      Card temp_computer_card = computer.remove(0);

      if (player.isEmpty())
      {
         game_over = 1;
         System.out.println("Computer won the game!");
      }
      else if (computer.isEmpty())
      {
         game_over = 1;
         System.out.println("Player won the game!");
      }
      if (game_over == 0)
      { 
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
            //System.out.println("Putting: " + temp_player_card + " back in player");
            //System.out.println("Putting: " + temp_computer_card + " back in computer");
   
            player.add(0, temp_player_card);
            computer.add(0, temp_computer_card);
            war_var = this.warRound();
            return 0;
         }
       }//game continues
       return 5;
   }//end play round
     
      /**
the warRound method is used by the playRound method and should not be accessed elsewhere. 
*/
      
      private int warRound()
      {
         System.out.println("War!");
         Card warCard;
         Card temp_player_card = player.remove(0);
         Card temp_computer_card = computer.remove(0);

         warPile.add(temp_player_card); //put the current cards into the pile
         warPile.add(temp_computer_card); //put the current cards into the pile
         temp_player_card = player.remove(0); //put the next card into the pile
         temp_computer_card = computer.remove(0); //put the next card into the pile
         if (player.isEmpty())
         {
            game_over = 1;
            System.out.println("Computer Won during War!");
         }
         else if (computer.isEmpty())
         {
            game_over = 1;
            System.out.println("Player Won during War!");
         }
         if (game_over == 0)
         {
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
         }//game over is zero
         return 5;
     }//warRound method
   
//    public static void main(String[] args) throws IndexOutOfBoundsException
//    {
//        int blah = 1;
// 
//       try
//       {
//          War warGame = new War();
//          Card testCard = warGame.player.get(0); //trying to figure out how to setImageIcon
//         
//          
//          do
//          {
//             blah = warGame.playRound();
//             System.out.println("Round: " + warGame.round_count);
// 
//          } while(true);
//       } //try
//       catch (IndexOutOfBoundsException e)
//       {
//          System.out.println("Game Over");
//          if (blah==3) System.out.println("Computer Won");
//          if (blah==2) System.out.println("Player Won");
//          
//       }//catch
//       //warGame.warRound();
// 
//       
//       //System.out.println("Round: " + warGame.round_count);
//    }//main
}//public class 