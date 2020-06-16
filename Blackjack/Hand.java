import java.awt.*;
import java.util.*;

public class Hand
{
	public int count = 0;
	private Card[] hand;
	
//DEFAULT CONSTRUCTOR - CREATES NEW HAND OF CARDS
	public Hand() 
   {
		hand = new Card[20];
	}
   
//ADDS NEW CARD TO HAND
	public void add(Card card)
   {
		hand[count++] = card;
	}
   
//RETURNS THE TOP CARD IN HAND
	public Card getTopCard()
   {
		return hand[0];
	}
//FINDS THE VALUE OF THE CARDS BY ADDING UP EACH CARDS VALUE
	public int valueOf()
   {
		int sum=0;
		int rank=0;
		int count2= count;
		int aces = 0;
      
		for(int i=0; i< count2; i++)
      {
			rank = hand[i].valueOf();
			sum += rank;
			if( rank == 11)
				aces++;
		}
      
		while (aces > 0 && sum >21)
      {
			sum -= 10;
			aces--;
		}		
		return sum;
	}
//CHECKS IF THEY HAVE BLACKJACK
	public boolean hasBlackJack()
   {
		int total = hand[0].valueOf() + hand[1].valueOf();
		return total ==21;
	}
   
//CHECKS IF THEY'VE BUSTED
	public boolean isBusted()
   {
		return valueOf() > 21;
	}
 
 //OUTPUT
	public String toString()
   {
		String string = "";
		int count3 = count;
      
		for(int i=0; i< count3; i++)
      {
			string += hand[i].toString();
			string += "\n";
		}
      
		if(isBusted())
      {
			string += "\n\n";
			string += "You Busted!";
		}
      
		if(hasBlackJack())
      {
			string += "\n\n";
			string += "You have Blackjack!";
		}
		return string;
	}
   
	public static void main(String[] args)
   {
		Deck deck = new Deck();
		deck.shuffle();
		Hand a = new Hand();
		a.add(deck.nextCard());
		a.add(deck.nextCard());
		a.add(deck.nextCard());
      
		System.out.println(a.toString());
		System.out.println(a.valueOf());
	}
}
	