### Lecture 10

Assume `ILoRectangle`

```java
ILoRectangle findAreaUnder40();   // Filter-like 
ILoRectangle findAllRed();        // in nature
double totalArea();
double totalPerim();
ILoRectangle doubleInSize();
ILoRectangle makeRed();


interface ILoRectangle { 
  ILoRectangle findAllRed();
}

class Rectangle {
  Color color;
  int width;
  int height;
  
  boolean isRed() {
    return this.color.equals(Color.RED);
  }
  
  double area() {
    return height * width;
  }
}

class ConsLoRectangle implements ILoRectangle{
  ILoRectangle rest;
  Rectangle first;
  
  ILoRectangle findAllRed() {
    if( this.first.isRed() ) {
      return new ConsLoRectangle(this.first, this.rest.findAllRed());
    } else {
      return this.rest.findAllRed();
    }
  }
  
  ILoRectangle findAreaUnder40() {
    if( this.first.area() < 40 ) {
      return new ConsLoRectangle(this.first, this.rest.findAreaUnder40());
    } else {
      return this.rest.findAreaUnder40();
    }
  }
}

class MtLoRectangle implements ILoRectangle {	
  ILoRectangle findAllRed() {
    return new MtLoRectangle();
  }
  
  ILoRectangle findAreaUnder40() {
    return new MtLoRectangle();
  }
}
```

Abstractions

```java
//Functional Interface
interface IRectPred {  
  boolean matches(Rectangle r);
}

class ConsLoRectangle implements ILoRectangle { 
  public ILoRectangle filter(IRectPred p) {        
    if (p.matches(this.first)) {      
      return new ConsLoRectangle(this.first, this.rest.filter(p));    
    } else {      
      return this.rest.filter(p);    
    }  
  }    
  // p is a question for rectangles  
  ILoRectangle filter(IPred p) {    
    if( p.ask(this.first) ) {      
      // c1: this.first does something to p   <-- doesn't make sense, because       	  //                                       why should a Rect (this.first)       	  //                                       do something to a question?      
      // c2: p does something to this.first         
      return new ConsLoRectangle(this.first, this.rest.filter(p));    
    } else {      
      return this.rest.filter(p);   
    }  
  }    
  
  public ILoRectangle findAllRed() {    
    return this.filter(new IsRedRect);  
  }    
  public ILoRectangle findAllUnder40() {    
    return this.filter(new AreaUnder(40));  
  }    
  public ILoRectangle findAllUnder60() {    
    return this.filter(new AreaUnder(60));  
  }
}
interface IPred {  
  boolean ask(Rectangle r);
}
class IsRed implements IPred {  
  boolean ask(Rectangle r) {    
    return r.color.equals(Color.RED); 
  }
}

// Function Objects
class IsRedRect implements IRectPred {  
  public boolean matches(Rectangle r) {    
    return r.color.equals(Color.RED);  
  }
}

// This is a closure
class AreaUnder implements IRectPred {  
  double target;    
  AreaUnder(double t) {    
    this.target = t;  
  }    
  public boolean matches(Rectangle r) {    
    return r.area() < this.target;  
  }
}

// Map
class Rectangle {
  Color c;
  int width;
  int height;
  
  Rectangle(Color c, int w, int h) {
    this.c = c;
    this.width = w;
    this.height = h;
  }
  
  Rectangle doubleSize() {
    return new Rectangle(c, width * 2, height * 2);
  }
  
  Rectangle redRect() {
    return new Rectangle(Color.RED, width, height);
  }
}

interface IPred {
  Rectangle apply(Rectangle r);
}

class doubleSizeOfRect implements IPred {
  public Rectangle apply(Rectangle r) {
    return new Rectangle(r.color, r.size * 2);
  }
}

class makeRedRect implements IPred {
  public Rectangle apply(Rectangle r) {
    return new Rectangle(Color.RED, r.size);
  }
}


interface ILoRectangle {  
  // returns a list of rectangles where all the sizes have doubled
  ILoRectangle doubleInSize();	
  
  // returns a list of rectangles where the color is now red
  ILoRectangle makeRed();
}

class ConsLoRectangle implements ILoRectangle {
  Rectangle first;
  ILoRectangle rest;
  
  ILoRectangle map(IPred p) {
    return new ConsLoRectangle(p.apply(this.first), this.rest.map(p))
  }
  
  ILoRectangle doubleInSize() {
    return this.map(new doubleSizeOfRect());
  }
  
  ILoRectangle makeRed() {
    return this.map(new makeRedRect());
  }
  
  /*
  ILoRectangle doubleInSize() {
    return new ConsLoRectangle(this.first.doubleSize(), this.rest.doubleInSize());
  }
  
  ILoRectangle makeRed() {
    return new ConsLoRectangle(this.first.redRect(), this.rest.makeRed());
  }
  */
}

class MtLoRectangle implements ILoRectangle {
  ILoRectangle doubleInSize() {
    return this;
  }
  
  ILoRectangle makeRed() {
    return this;
  }
}
```

Lambda in Java:

```
myList.filter((r) -> r.area < 40);
```

To define an And Predicate

```java
class AndPred implements IRectPred{
  IRectPred p1,p2;
  public boolean matches(Rectangle r) {
    return this.p1.matches(r) && this.p2.matches(r);
  }
  // It needs a constr
  AndPred(IRectPred p1, IRectPred p2) {
    this.p1 = p1;
    this.p2 = p2;
  }
}

// to use inside of conslo
public ILoRectangle findAllRedAndUnder40() {
  return this.filter( new AndPred(new IRedRect(), new AreaUnder(40)) );
}

// inside mt
public ILoRectangle filter(IRectPred p) {
  return this;
}
```

