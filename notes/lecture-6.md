### Lecture 6

Other Problems:

```java
interface ILoInt {
  boolean hasAll();
  boolean hasAllAcc(boolean even, boolean posOdd, boolean fiveTen);
}

class ConsLoInt {
  int first;
  ILoInt rest;
  
  /* Problem 2 Variant B Solution */
  boolean hasAllAcc(boolean even, boolean posOdd, boolean fiveTen) {
    return this.rest.hasAllAcc(even || this.first is even, posOdd, fiveTen)
        || this.rest.hasAllAcc(even, posOdd || this.first is odd, fiveTen)
        || this.rest.hasAllAcc(even, posOdd, fiveTen || this.first in [5,10] )
  }
}
```

What you can do in OOD that wasn't in Racket:

```java
interface IShape {}

//super class or base class
class Rect implements IShape {
  int width;
  int height;
  Color color;
  Posn topLeft;
}

//sub class or derived class
class Square extends Rect {
  Square(int size, Color c, Posn tL) {
    super(size, size, c, tL);
  }
}

class Circle implements IShape {
  int radius;
  Color color;
  Posn center;
}
```

**Inheritance**: A class gets all the methods and fields of the super class

Base Classes are only for abstracting common code

Interfaces promise behavior

