import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

public class BlackJack
{

	public Hand player;
	public Hand dealer;
	public Deck deck;
	private int play = 0;
	private int hit = 0;
	public BlackJackGUI GUI;
	private int stand =0;
   
	public BlackJack()
   {
	   GUI =  new BlackJackGUI();
	   GUI.setPlayAction(new PlayAction());
	   GUI.setHitAction(new HitAction());
	   GUI.setStandAction(new StandAction());
	   GUI.enablePlayButton();
	}
	
	class PlayAction implements ActionListener 
   {
   //When the play button is pressed, the deck and hands of each player are created
   //and the first card is displayed and the game begins.
	 public void actionPerformed (ActionEvent e) 
    {
	   deck = new Deck();
	   deck.shuffle();
	   player = new Hand();
	   dealer = new Hand();
      
	   player.add(deck.nextCard());
	   dealer.add(deck.nextCard());
	   player.add(deck.nextCard());
	   dealer.add(deck.nextCard());
      
	   GUI.displayPlayer(player);
	   GUI.displayDealerCard(dealer.getTopCard());
      
	   if(!player.hasBlackJack() && !dealer.hasBlackJack() && !player.isBusted())  
	      GUI.enableHitAndStandButtons();
   
	   if(player.hasBlackJack() || dealer.hasBlackJack() || player.isBusted())
		   finishGame();
	 
	 }
	}

	class HitAction implements ActionListener
   { 
   //When the hit button is pressed, another card is added.
	   public void actionPerformed (ActionEvent e)
      {

		   if(!player.isBusted() && player.valueOf() !=21)
         {
			   player.add(deck.nextCard());
			   GUI.displayPlayer(player);
		   }
         
		   if(player.isBusted() || player.valueOf()==21)
		      finishGame();
	  }
	}
   
	class StandAction implements ActionListener
   {
   //When the stand button is pressed, the game ends
	   public void actionPerformed (ActionEvent e) 
      {
		   finishGame();
	   }
	}
	private void finishGame()
   {
		if(player.hasBlackJack()) //IF PLAYER HAS BLACKJACK
       {
		   GUI.displayDealer(dealer);
		   GUI.displayPlayer(player);
		   GUI.displayOutcome("You Win!");
       }
      
		else if (dealer.hasBlackJack() && player.hasBlackJack()) //IF BOTH HAVE BLACKJACK
       {
		   GUI.displayDealer(dealer);
		   GUI.displayPlayer(player);
		   GUI.displayOutcome("Push! Wow!");
       }
       
		else if(dealer.hasBlackJack()) //IF DEALER HAS BLACKJACK
      {
		   GUI.displayDealer(dealer);
		   GUI.displayPlayer(player);
		   GUI.displayOutcome("You Lose!");
      }
      
		else if (player.isBusted()) //IF PLAYER BUSTS
      {
		   GUI.displayDealer(dealer);
		   GUI.displayPlayer(player);
		   GUI.displayOutcome("You Lose!");
      }
      
		else //INCLUDES OPTIONS THAT REQUIRE THE DEALER TO HIT/STAND
        {
			while( dealer.valueOf()<17 && !dealer.isBusted() )
         {
			   dealer.add(deck.nextCard());
			}
         
		   if(dealer.isBusted())  //IF DEALER BUSTS
			{
            GUI.displayDealer(dealer);
		      GUI.displayPlayer(player);
			   GUI.displayOutcome("You Win!");
         }
         
         else if (dealer.hasBlackJack()) //IF DEALER GETS BLACKJACK
         {
			   GUI.displayDealer(dealer);
		      GUI.displayPlayer(player);
		      GUI.displayOutcome("You Lose!");
			} 
         
		   else if (dealer.valueOf() == player.valueOf()) //IF THEY TIE
			{
            GUI.displayDealer(dealer);
			   GUI.displayPlayer(player);
			   GUI.displayOutcome("Push! Wow!");
         }
         
		   else if (dealer.valueOf() > player.valueOf()) //DEALER > PLAYER
         {
			   GUI.displayDealer(dealer);
	         GUI.displayPlayer(player);
		   	GUI.displayOutcome("You Lose!");
         }
         
		   else if (player.valueOf() > dealer.valueOf()) //PLAYER > DEALER
         {
			   GUI.displayDealer(dealer);
		      GUI.displayPlayer(player);
		      GUI.displayOutcome("You Win!");
         }
			 
		}
		GUI.enablePlayButton();
	}	
   
	public static void main(String[] args)
   {
		new BlackJack();
	}

}