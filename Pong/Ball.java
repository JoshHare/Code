//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
      setWidth(10);
      setHeight(10);
      setColor(Color.BLACK);
	}

	//add the other Ball constructors
	public Ball(int x, int y)
   {
	  super(x,y); 
     xSpeed = 3;
	  ySpeed = 1;
     setColor(Color.BLACK);
     setWidth(10);
     setHeight(10);
   }
	
	public Ball(int x, int y, int w, int h)
   {
      super(x,y,w,h);
      xSpeed = 3;
		ySpeed = 1;
      setColor(Color.BLACK);
   }
   
   public Ball(int x, int y, int w, int h, Color c)
   {
      super(x,y,w,h,c);
      xSpeed = 3;
		ySpeed = 1;
   }
   
   public Ball(int x, int y, int w, int h, Color c, int xS)
   {
      super(x,y,w,h,c);
      xSpeed = xS;
      ySpeed = 1;
   }
   
   public Ball(int x, int y, int w, int h, Color c, int xS, int yS)
   {
      super(x,y,w,h,c);
      xSpeed = xS;
      ySpeed = yS;
   }
	
	public void setXSpeed(int x)
   {
      xSpeed = x;
   }
   
   public void setYSpeed(int y)
   {
      ySpeed = y;
   }
   //add the set methods
   

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location

      super.draw(window,Color.white);
      setX(getX()+xSpeed);
		//setY
      setY(getY()+ySpeed);
		//draw the ball at its new location
      super.draw(window);
      
   }
   
	public boolean equals(Object obj)
	{
      Ball other = (Ball) obj;
      if(super.equals(other))
         if(this.getXSpeed()==other.getXSpeed())
            if(this.getYSpeed()==other.getYSpeed())
               return true;

		return false;
	}   

   //add the get methods
   public int getXSpeed()
   {
      return xSpeed;
   }
   
   public int getYSpeed()
   {
      return ySpeed;
   }

   //add a toString() method
   public String toString()
   {
   return super.toString() + " " + getXSpeed() + " " + getYSpeed();
   }
   
   public boolean didCollideLeft(Object obj)
   {
     Paddle p = (Paddle) obj;
     if(p.getX()==this.getX()+this.getWidth()/*&&this.getX()<=p.getX()*/ &&this.getY() >= p.getY() && this.getY()<= p.getY()+p.getHeight())
     
      return true;
     return false;
   }
	public boolean didCollideRight(Object obj)
   {
     Paddle p = (Paddle) obj;
     if(p.getX()+p.getWidth() ==this.getX() && this.getX() <= p.getX() + p.getWidth()  &&  this.getY() <= p.getY() && this.getY()>= p.getY()+p.getHeight())
      return true;      
      return false;
   }
	public boolean didCollideTop(Object obj)
   {
     Paddle p = (Paddle) obj;
     if(p.getX()+p.getWidth() <=this.getX() && this.getX() <= p.getX() + p.getWidth()  &&  this.getY()== p.getY())
      return true;
      return false;
   }
	public boolean didCollideBottom(Object obj)
   {
     Paddle p = (Paddle) obj;
    if(p.getX() <=this.getX() && this.getX() <= p.getX() + p.getWidth()  &&  this.getY()== p.getY()-p.getHeight())
return true;
      return false;
   }

}

