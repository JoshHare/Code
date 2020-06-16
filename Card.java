import java.awt.*;
import java.util.*;

public class Card 
{
   private int suit;
	private int rank;
	private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
   private static final String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	
	public Card(int suit, int rank)
   {
		this.suit = suit;
		this.rank = rank;
	}
   
	public int valueOf()
   {
		if (this.rank ==0) //ACE
		   return 11;
		
		if (this.rank < 10) //NUMBER CARDS
		   return rank + 1;
		
		if(this.rank >=10) //JACK, QUEEN, KING
		   return 10;
		
		else
		   return 0;
		
	}
   
	public String toString()
   {
		//returns a String representing the Card in form "Ace/Three/King of Hearts"
	   return ranks[this.rank] + " of " + suits[this.suit];
	}
   
	public static void main(String[] args)
   {
     //CARD TESTS
		Card a = new Card(0,0);
		System.out.println("Card a has a value of " + a.valueOf() + " and is a " + a.toString());
		Card b = new Card(3,4);
		System.out.println("Card a has a value of " + b.valueOf() + " and is a " + b.toString());
		Card c = new Card(3,12);
		System.out.println("Card a has a value of " + c.valueOf() + " and is a " + c.toString());
	}
}