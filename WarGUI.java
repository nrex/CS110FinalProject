import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   private War warGame;
   private JPanel leftPanel= new JPanel(new GridLayout(2,1,1,4));
   private JPanel rightPanel= new JPanel(new GridLayout(2,1,1,4));
   private JPanel buttons = new JPanel(new GridLayout(4,1,2,2));
   private JButton playButton, exit, newGameButton;
   private JLabel status, title, per, com;

   
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
      
      
      playButton.addActionListener(new PlayButtonListener());
      newGameButton.addActionListener(new NewGameButtonListener());
      exit.addActionListener(new ExitHandler());
      
      leftPanel.add(playButton);
      leftPanel.add(newGameButton);
      
      
      title = new JLabel("Nate's War Game"); 
      buttons.add(title);
      //status = new JLabel("Game in Progress");
      //buttons.add(status);
      per = new JLabel("Your Card:");
      com = new JLabel("Computer's Card:");
      buttons.add(playButton);
      buttons.add(newGameButton);
      buttons.add(exit);
      this.getContentPane().add(buttons);
      pack();
      leftPanel.add(per);
      rightPanel.add(com);
      
      add(leftPanel);
      add(rightPanel);
      
      setVisible(true);
      
      
      
   }//war GUI
   
   class PlayButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {     
         if (e.getSource() instanceof JButton)
         {   
            JButton b = (JButton)(e.getSource());
            WarGUI.warGame.playRound();    
         } 
      }//actionPerformed for PlayButtonListener
   }//PlayButtonListener
   
   class NewGameButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {     
         if (e.getSource() instanceof JButton)
         {
            War warGame = new War();  
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
	  new WarGUI();

   }
    
           


}
      
      