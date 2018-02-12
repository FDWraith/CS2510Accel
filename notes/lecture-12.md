### Lecture 12

```java
interface IList<T> { 
  <U> IList<U> map(IFunc<T,U> f);
}

interface IFunc<T,U> {  
  U apply(T t);
}


IList<IShape> shapes = ......;
IList<Double> perims = shapes.map(new Shape2Perim());

class Shape2Perim implements IShapeFunc<Double> {
  public Double visitCircle(Circle c) {
  	return PI * c.radius ^ 2;	
  }
  public Double visitSquare(Square s) {
    return s.side ^ 2;
  }
  public Double visitRect(Rect r) {
    return r.width * r.height;
  }
  public Double apply(IShape s) {
    return s.accept(this);
  }
}

// VISITOR PATTERN
interface IShapeFunc<R> extends IFunc<IShape,R> { //Important to have R here to ensure the return types of following methods to be consistent
  R visitCircle(Circle c);
  R visitSquare(Square s);
  R visitRect(Rect r);
}

interface IShape { 
  // Not all methods in Shape is gonna use T
  
 
  // <T> introduces generic "T"
  // T is the return type 
  // beAppliedToBy = method name
  // IShapeFunc<T> the function being applied to "this" shape
  <T> T accept(IShapeFunc<T> f);
  // f is applied to "this" shape
}

class Circle implements IShape {
  // I think this is how it's done... 
  <T> T accept(IShapeFunc<T> f) {
    return f.visitCircle(this);
  } 
}
```