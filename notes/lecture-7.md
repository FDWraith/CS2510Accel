### Lecture 7

```java
interface IShape {
  double area();
  double distToOrig();
  IShape grow(double factor);
  boolean biggerThan(IShape other);
}

abstract class AShape implements IShape {
  Posn refPt; // reference point for the shape
              // doesn't really MEAN anything rn.. it's just there
  
  public boolean biggerThan(IShape other){
  	return this.area() > other.area();  
  }
  
  public double distToOrig() {
    return this.refPt.distToOrig();
  }
}

class Circle extends AShape {
  double radius;
  
  Circle(double radius, Posn ref) {
    this.radius = radius;
    this.refPt = ref;
  }
  
  public double distToOrig() {
    return super.distToOrig() - this.radius;
  }
} 


class Square extends AShape {
  double side;
  
  
}
```

**Override**: More specific definition of a method overrides the inherited one.



The difference is mainly what you're relying on.

when you use super.distToOrig().. you're calling the abstract class's method.

when you do this.refPt.distToOrig()... you're relying on refPt's name staying the same