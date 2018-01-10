import tester.*;
import java.awt.Color;
import javalib.worldimages.*;
 
class BouncingBall {
  Posn pos;
  Color color;
  int size; // size is the radius of the ball
  int dx; // how fast is the ball moving to the right?
  int dy; // how fast is the ball moving downward?
 
  BouncingBall(Posn pos, Color color, int size, int dx, int dy) {
    this.pos = pos;
    this.color = color;
    this.size = size;
    this.dx = dx;
    this.dy = dy;
  }
 
  // Returns a new BouncingBall that's just like this BouncingBall, but moved
  // by this BouncingBall's dx and dy
  BouncingBall move() {
    Posn newPosn = new Posn(this.pos.x + this.dx, this.pos.y + this.dy);
    return new BouncingBall(newPosn, this.color, this.size, this.dx, this.dy);
  }
 
  // Returns a new BouncingBall that represents this BouncingBall just after
  // it has bounced off a side wall. Does not actually move the ball
  BouncingBall bounceX() {
    return new BouncingBall(this.pos, this.color, this.size, this.dx * -1, this.dy);
  }
 
  // Like bounceX, except for using the top or bottom walls
  BouncingBall bounceY() {
    return new BouncingBall(this.pos, this.color, this.size, this.dx, this.dy * -1);
  }
 
  // Does the ball collide with a side wall?
  boolean collidesX(Posn topLeft, Posn botRight) {
    int leftLimit = topLeft.x;
    int rightLimit = botRight.x;
    int ballX = this.pos.x;
    return (ballX - this.size <= leftLimit)
        || (ballX + this.size >= rightLimit);
  }
 
  // Does the ball collide with a top or bottom wall?
  boolean collidesY(Posn topLeft, Posn botRight) {
    int topLimit = topLeft.y;
    int botLimit = botRight.y;
    int ballY = this.pos.y;
    return (ballY - this.size <= topLimit)
        || (ballY + this.size >= botLimit);
  }
}

class ExamplesBouncingBalls {
  int WIDTH = 300;
  int HEIGHT = 300;
  
  BouncingBall b1 = new BouncingBall(new Posn(0,0), Color.red, 5, 2, -2);
  BouncingBall b2 = new BouncingBall(new Posn(20,10), Color.green, 5, 2, -2);

  // NOTE: We have provided BouncingWorld for you, in the starter code.
  // We'll see how it works in a few lectures
  boolean testBigBang(Tester t) {
    BouncingWorld w = new BouncingWorld(WIDTH, HEIGHT);
    return w.bigBang(WIDTH, HEIGHT, 0.1);
  }
  
  // test for method move
  boolean testMove(Tester t) {
    return t.checkExpect(b1.move().pos, new Posn(2,-2));
  }
  
  // test for method bounceX
  boolean testBounceX(Tester t) {
    return t.checkExpect(b1.bounceX().dx, -2);
  }
  
  //test for method bounceY
  boolean testBounceY(Tester t) {
    return t.checkExpect(b1.bounceY().dy, 2);
  }
  
  // test for method collidesX
  boolean testCollidesX(Tester t) {
    return t.checkExpect(b1.collidesX(new Posn(0,0), new Posn(10,10)), true)
        || t.checkExpect(b2.collidesX(new Posn(0,0), new Posn(30,20)), false);
  }
  
  //test for method collidesY
  boolean testCollidesY(Tester t) {
    return t.checkExpect(b1.collidesY(new Posn(0,0), new Posn(10,10)), true)
        || t.checkExpect(b2.collidesY(new Posn(0,0), new Posn(30,20)), false);
  }
}