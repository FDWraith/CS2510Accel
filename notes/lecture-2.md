### Lecture 2

Logical Operators:

```java
&&; // and
||; // or
!(5 == 4); // not
!=; // not equal
==; // equal
```

Sample Union Data:

Lunch

- Sandwich
  - String bread
  - String filling
- Pho
  - double noodleLength
  - String broth
  - boolean isSpicy
- Pizza
  - boolean hasPepperoni
  - double sliceAngle

Represented in Java:

```java
// to represent a lunch
interface ILunch { }

// to represent a sandwich to be eaten at lunch
class Sandwich implements ILunch {
  String bread;
  String filling;
  
  Sandwich( String bread, String filling ) {
    this.bread = bread;
    this.filling = filling;
  }
}

// the same for Pho and Pizza
```

Interfaces have flexibility and insurance over union-data, since new classes can implement these interfaces and work with interface methods as before.

**Interfaces are a way to document how clients of your code should be using your code.**

Example:

```java
// to represent simple geometric shapes
interface IShape { 
  double area();
}

// to represent a square
class Square implements IShape { 
  int sideLen;
  
  Square( int sideLen ) {
    this.sideLen = sideLen;
  }
  double area( ) {
    return sideLen * sideLen * 1.0;
  }
}

// to represent a circle
class Circle implements IShape {
  int radius;
  
  Circle( int radius ) {
    this.radius = radius;
  }
  double area( ) {
    return Math.PI * radius * radius;
  }
}
```

```java
class Point2D {
  int x;
  int y;
  
  Point2D( int x, int y ) {
    this.x = x;
    this.y = y;
  }
  
  // returns the result of translating this point by dx and dy
  Point2D translate( int dx, int dy ) {
    return Point2D( this.x + dx, this.y + dy );
  }
}
```

Method Invocation:

```java
Point2D origin = new Point2D(0,0);
Point2D right = origin.translate(5,0);
```

Check Expects with the Tester Library:

```java
boolean testTranslate( Tester t ) {
  return t.checkExpect( origin.translate(3,4), newPoint(3,4) );
}
```

