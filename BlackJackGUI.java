import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

public class BlackJackGUI extends JFrame {

  private Container contentPane;
  private JPanel buttonPanel = new JPanel();
  private JButton playButton = new JButton("Play ");
  private JButton hitButton = new JButton("Hit  ");
  private JButton standButton = new JButton("Stand");
  private JPanel outputPanel = new JPanel();
  private JTextArea playerArea = new JTextArea();
  private JTextArea dealerArea = new JTextArea();

  //Construct the frame

  public BlackJackGUI()
  {
    contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    outputPanel.setLayout(new BorderLayout());
    outputPanel.setBackground(new Color(0,122,0));
    setSize(new Dimension(600, 400));
    setTitle("BlackJack");

    contentPane.add(buttonPanel,  BorderLayout.SOUTH);
    buttonPanel.add(playButton, null);
    buttonPanel.add(hitButton, null);
    buttonPanel.add(standButton, null);
    
    contentPane.add(outputPanel, BorderLayout.CENTER);
    outputPanel.setLayout(new FlowLayout());
    outputPanel.add(playerArea, null);
    outputPanel.add(dealerArea, null);
    
    hitButton.setEnabled(false);
    standButton.setEnabled(false);
    
    playerArea.setText("  ");
    dealerArea.setText("  ");
    int width = getWidth();
    int height = getHeight();
    playerArea.setPreferredSize(new Dimension(width/2-20,height));
    playerArea.setBackground(new Color(0,122,0));
    dealerArea.setBackground(new Color(0,122,0));
    dealerArea.setPreferredSize(new Dimension(width/2-20,height));
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }
  //SETS FOR BUTTONS

  public void setPlayAction(ActionListener listener)
  {
    playButton.addActionListener(listener);
  }

  public void setHitAction(ActionListener listener)
  {
    hitButton.addActionListener(listener);
  }

  public void setStandAction(ActionListener listener)
  {
    standButton.addActionListener(listener);
  }
  
  
//DISPLAYS HAND
  public void displayPlayer(Hand hand)
  {
    playerArea.setText("Player:\n"+hand.valueOf()+"\n"+hand);
  }

  public void displayDealer(Hand hand)
  {
    dealerArea.setText("Dealer:\n"+hand.valueOf()+"\n"+hand);
  }

  public void displayDealerCard(Card card)
  {
    dealerArea.setText("Dealer Shows:\n"+card);
  }
  
  
//THIS PRINTS THE PARAMETER IN THE PLAYER AREA
  public void displayOutcome(String outcome)
  {
    playerArea.setText(playerArea.getText()+"\n\n"+outcome);
  }

//PREPS BUTTONS
  public void enableHitAndStandButtons()
  {
    playButton.setEnabled(false);
    hitButton.setEnabled(true);
    standButton.setEnabled(true);
  }

  public void enablePlayButton()
  {
    playButton.setEnabled(true);
    hitButton.setEnabled(false);
    standButton.setEnabled(false);
  }

  public static void main(String[] args)
  {
    new BlackJackGUI();
  }

}