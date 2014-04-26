import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   private War game;
   private JPanel topPanel,leftPanel,rightPanel;
   private JButton playButton;
   private JButton newGameButton;
   private Jlabel status;
   private Jlabel title;
   
   public WarGUI()
   {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new GridLayout(2,2));
      game = new War();
      topPanel = new Jpanel();
      leftPanel = new Jpanel();
      rightPanel = new Jpanel();
      
      playButton =new JButton();
      newGameButton = new JButton();
      
      playButton.addActionListener(new ButtonListener());
      newGameButton.addActionListener(new ButtonListener());
      leftPanel.add(playButton);
      leftPanel.add(newGameButton);
      
      
      title = new JLabel("Nate's War Game");
      topPanel.add(title);
      
      status = new JLabel("Game in Progress");
      topPanel.add(Status);
      
      add(topPanel);
      add(leftPanel);
      add(rightPanel);
      
   }//war GUI
   
    private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {     
         char winner;  

         Button source = (e.getSource());
         // make a move
         if (game.move(source.getRow(),source.getCol()))
         {
            // react
            if (game.getPlayer() == 'o')
               source.setIcon(new ImageIcon("x.jpg"));
            else
               source.setIcon(new ImageIcon("o.jpg"));
            
            winner = game.winner();
            
            if ((winner !='_')||game.getMoves()==9)
               if (winner != '_')
               {
                  status.setText("Winner is " + winner);
                  disableAll();
                 
               }
               else
               {
                  status.setText("It's a tie");
                  disableAll();

               
               }
              
         }
      }
      // disable all buttons
      public void disableAll()
      {
         for (int r=0;r<3;r++)
            for(int c=0;c<3;c++)
            {
               buttons[r][c].setEnabled(false);
            }
      
      }
   }     


}
      
      