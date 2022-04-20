import processing.core.PApplet;
import processing.core.PImage;

/**
  * A program that uses an image as a background, animates an image that uses basic edge detection, and animates a shape that moves in a parabolic path.
  * @author: B. Zhang
  */

public class Sketch extends PApplet {
  // global image variable
  PImage imgBackground;
  PImage imgBouncyBall;
	
  // random starting points and set speed for the circle
  float fltCircleX = random(50, 950);
	float fltCircleY = random(50, 950);
	float fltCircleXSpeed = 10;
	float fltCircleYSpeed = 6;

  // starting points and x speed of the bouncy ball
  float fltBallX = 0;
  float fltBallY = 0;
  float fltBallXSpeed = 6;

  public void settings() {
    size(1000, 600);
  }

  public void setup() {
    // loading and resizing background and bouncy ball images
		imgBackground = loadImage("gymnasium.jpg");
    imgBackground.resize(width, height);

    imgBouncyBall = loadImage("bouncyball.png");
    imgBouncyBall.resize(75, 75);
  }

  public void draw() {
    // draw background
    image(imgBackground, 0, 0);
    
    // parabola function that the ball will follow
    float fltParabola = (float) Math.pow(fltBallX - 400,2);
    
    // draw bouncy ball
    image(imgBouncyBall, fltBallX, fltBallY);

    // animating the bouncy ball to follow the parabola using dependent and independent variables
    fltBallY = (fltParabola/600) + 25;
    fltBallX += fltBallXSpeed;

    // if the x coordinate of the ball collides with the right side, the x speed is reversed 
    if (fltBallX > 935) {
      fltBallXSpeed = -fltBallXSpeed;
    } 

    // if the x coordinate of the ball collides with the left side, the x speed is reversed
    else if (fltBallX < 0) {
      fltBallXSpeed = -fltBallXSpeed;
      fltBallX = 0;
    }

    // setting orange colour and drawing the circle
    fill(255,170,0);
	  ellipse(fltCircleX, fltCircleY, 100, 100);

    // animating the circle to follow a linear path
		fltCircleX += fltCircleXSpeed;
		fltCircleY += fltCircleYSpeed;

    // if the circle touches the right or left side, the x speed is reversed
    if(fltCircleX < 50 || fltCircleX > width - 50){
      fltCircleXSpeed = -fltCircleXSpeed;
    }

    // if the circle touches the top or bottom, the x speed is reversed
    if(fltCircleY < 50 || fltCircleY > height - 50){
      fltCircleYSpeed = -fltCircleYSpeed;
    }
  }
}