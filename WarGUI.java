import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   private War warGame; //warGame 
   private JPanel leftPanel= new JPanel(new GridLayout(5,1,2,2)); //player info
   private JPanel rightPanel= new JPanel(new GridLayout(5,1,2,2));//computer info
   private JPanel buttons = new JPanel(new GridLayout(5,1,2,2)); //button panel
   private JButton playButton, exit, newGameButton, finish;
   private JLabel status, title, per, com, round, round_winner, pCC, cCC;
   private ImageIcon cardBack;
   
   private JLabel back1 = new JLabel();
   private JLabel back2 = new JLabel();
   
   public WarGUI()
   {
      super("War Game"); //JFrame
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new GridLayout(1,4));
      warGame = new War();  
   
      leftPanel = new JPanel();
      rightPanel = new JPanel();
      
      playButton =new JButton("Play a round!");
      newGameButton = new JButton("Play a new game...");
      exit = new JButton("Exit");
      finish = new JButton("Play lots of rounds."); //finish game
      
      cardBack = new ImageIcon("back.jpg");
      
      finish.addActionListener(new FinishButtonListener());//finish game
      playButton.addActionListener(new PlayButtonListener());
      newGameButton.addActionListener(new NewGameButtonListener());
      exit.addActionListener(new ExitHandler());
      
      round = new JLabel("Round: ");
      round_winner = new JLabel(" ");
      
      pCC = new JLabel("Player Card Count: ");
      cCC = new JLabel("Computer Card Count: ");
      
      
      title = new JLabel("Nate's War Game"); 
      buttons.add(title);
      //status = new JLabel("Game in Progress");
      //buttons.add(status);
      per = new JLabel("Your Card:");
      com = new JLabel("Computer's Card:");
      

      back2.setIcon(cardBack);
      back1.setIcon(cardBack); //yo what am i doing?
      
      
      buttons.add(playButton);
      buttons.add(newGameButton);
      buttons.add(finish);//finish game
      buttons.add(exit);
      this.getContentPane().add(buttons);
      pack();
      leftPanel.add(per);
      rightPanel.add(com);
      
      leftPanel.add(back1);
      rightPanel.add(back2);
      
      leftPanel.add(pCC);
      rightPanel.add(cCC);
      
      add(leftPanel);
      add(rightPanel);
      
      setVisible(true);
      
      
      
   }//war GUI
   
   class FinishButtonListener implements ActionListener 
   {
      public void actionPerformed(ActionEvent e) throws IndexOutOfBoundsException, NullPointerException
      {     
         if (e.getSource() instanceof JButton)
         { 
            int blah=0;
            
            do
            {
               blah = warGame.playRound();   
            } while((warGame.player.size()>3) && (warGame.computer.size()>3));
             //try
               leftPanel.remove(pCC);
               rightPanel.remove(cCC);
               rightPanel.remove(round_winner);
               leftPanel.remove(round);
               rightPanel.remove(round_winner);
               int winner = warGame.playRound();
               Card testCard1 = warGame.player.get(0);
               Card testCard2 = warGame.computer.get(0);
               back1.setIcon(testCard1.getImageIcon());
               back2.setIcon(testCard2.getImageIcon());
               round = new JLabel("Round: " + warGame.round_count);               //JLabel game_over = new JLabel("Game Over");
               //leftPanel.add(game_over);
               int playerCardCount = warGame.player.size();
               int computerCardCount = warGame.computer.size();
            
               pCC = new JLabel("\nPlayer Card Count: " + playerCardCount);
               cCC = new JLabel("\nComputer Card Count: " + computerCardCount);
            
               leftPanel.add(pCC);
               rightPanel.add(cCC);
               leftPanel.add(round);
      
            //catch
         }//if button source
      }//actionPerformer
   }//finish button listener
   
   
   class PlayButtonListener implements ActionListener //plays a round of war
   {
      public void actionPerformed(ActionEvent e)
      {     
         if (e.getSource() instanceof JButton)
         {   
            leftPanel.remove(pCC); //remove all of the old information
            rightPanel.remove(cCC);
            leftPanel.remove(round);
            rightPanel.remove(round_winner);
            int winner = warGame.playRound(); 
            
            if (warGame.game_over == 1) //game has ended
            {
               System.out.println("drag the corner of the GUI to display proper text...");
               round_winner = new JLabel("The game has ended.");
               rightPanel.add(round_winner); //for some reason this only displays when reformating the gui aka dragging the corner. 
               leftPanel.add(round_winner); 
            } 
            else {
            Card testCard1 = warGame.player.get(0);
            Card testCard2 = warGame.computer.get(0);
            back1.setIcon(testCard1.getImageIcon()); //flip 
            back2.setIcon(testCard2.getImageIcon());
            round = new JLabel("Round: " + warGame.round_count);
            
            
            int playerCardCount = warGame.player.size();
            int computerCardCount = warGame.computer.size();
            
            pCC = new JLabel("\nPlayer Card Count: " + playerCardCount); //display the number of cards player has
            cCC = new JLabel("\nComputer Card Count: " + computerCardCount); //display the number of cards computer has
            
            leftPanel.add(pCC);
            rightPanel.add(cCC); 
            
            
            
            if (testCard1.getRank()>testCard2.getRank()) 
            {
               round_winner = new JLabel("Player won!");

            }
            else if (testCard1.getRank()<testCard2.getRank())
            {
               round_winner = new JLabel("Computer won!");
            }
            else
            { 
               round_winner = new JLabel("War!");
            }
            rightPanel.add(round_winner);
            leftPanel.add(round);
            }//if the game has not been won.
         } 
      }//actionPerformed for PlayButtonListener
   }//PlayButtonListener
   
   class NewGameButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {     
         if (e.getSource() instanceof JButton)
         {
            leftPanel.remove(round_winner);
            leftPanel.remove(pCC);
            rightPanel.remove(cCC);
            leftPanel.remove(round);
            rightPanel.remove(round_winner);
            warGame = new War();
            back2.setIcon(cardBack);
            back1.setIcon(cardBack); 
//             System.out.println(warGame.player.size());
//             Card testCard1 = warGame.player.get(0);
//             Card testCard2 = warGame.computer.get(0);
//             back1.setIcon(testCard1.getImageIcon());
//             back2.setIcon(testCard2.getImageIcon());
            
            int playerCardCount = warGame.player.size();
            int computerCardCount = warGame.computer.size();
            
            pCC = new JLabel("\nPlayer Card Count: " + playerCardCount);
            cCC = new JLabel("\nComputer Card Count: " + computerCardCount);
            
            leftPanel.add(pCC);
            rightPanel.add(cCC);

            
            //System.out.println(warGame.player.size());
            //System.out.println(warGame.computer.size());
            //int blah = warGame.playRound();
            //System.out.println("Round: " + warGame.round_count);


         } 
      }//actionPerformed for PlayButtonListener
   }//PlayButtonListener
   
   
   
   
   private class ExitHandler implements ActionListener
   {
      public void actionPerformed(ActionEvent e) 
      {
         System.exit(0);
      }//actionPerformed for ExitHandler
   }//ExitHandler
   
   public static void main(String[] args) {
	  new WarGUI(); //gogo Gadget WARRRRR!!!!!!!!!!!!!!

   }// end of main
    
           


}// end of class
      
      