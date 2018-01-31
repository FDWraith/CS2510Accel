### Lecture 10

Assume `ILoRectangle`

```java
ILoRectangle findAreaUnder40();   // Filter-like 
ILoRectangle findAllRed();        // in nature
double totalArea();
double totalPerim();
ILoRectangle doubleInSize();
ILoRectangel makeRed();


interface ILoRectangle { 
  ILoRectangle findAllRed();
}

class Rectangle {
  Color color;
  
  boolean isRed() {
    return this.color.equals(Color.RED);
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
}

class MtLoRectangle implements ILoRectangle {	
  ILoRectangle findAllRed() {
    return new MtLoRectangle();
  }
}
```

Abstractions

```java
// Functional Interface
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
  
  // To Use on isRed
  public ILoRectangle findAllRed() {
    return this.filter(new IsRedRect());
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

