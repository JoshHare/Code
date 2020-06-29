//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
		super(10,10);
      speed =5;
      setWidth(10);
      setHeight(10);
      setColor(Color.black);
   }

	public Paddle(int x, int y)
   {
	  super(x,y); 
     speed = 5;
     setColor(Color.BLACK);
     setWidth(10);
     setHeight(10);
   }
   
   public Paddle(int x, int y, int s)
   {
      super(x,y);
      speed = s;
      setWidth(10);
     setHeight(10);
      setColor(Color.BLACK);
   }
	
	public Paddle(int x, int y, int w, int h)
   {
      super(x,y,w,h);
      speed = 5;
      setColor(Color.BLACK);

   }
   
   	public Paddle(int x, int y, int w, int h, int s)
   {
      super(x,y,w,h);
      speed = s;
      setColor(Color.BLACK);

   }

   
   public Paddle(int x, int y, int w, int h, Color c)
   {
      super(x,y,w,h,c);
      speed = 5;
   }
   
    public Paddle(int x, int y, int w, int h, Color c, int s)
   {
      super(x,y,w,h,c);
      speed = s;
   }
   

   
   public void setSpeed(int s)
   {
      speed =  s;
   }

   

   public void moveUpAndDraw(Graphics window)
   {
    draw(window,Color.white);

    setY(getY()+speed);
    super.draw(window);
    
   }

   public void moveDownAndDraw(Graphics window)
   {
   		draw(window,Color.white);

   setY(getY()-speed);
   super.draw(window);
   }

   //add get methods
   public int getSpeed()
   {
      return speed;
   }
   //add a toString() method
   public String toString()
   {
      return super.toString() + " " + getSpeed();
   }
}