### Lecture 17

```java
IList<Square> squares = new Cons<Square>(new Square(...), new Empty<Square>());
IList<IShape> shapes = squares; // illegal
```

```java
IList<T>; // generic list 
IList<IShape>; // generic list of IShapes
IList<T extends IShape>; // read-only list of IShapes
IList<T super Circle>; // write-only list of Circles
IList<T extends IShape super Circle>; // upper and lower bounds of the list
```

Some Visitor Review:

```java
interface IFooVisitor<Ret> extends IFunc<IFoo, Ret> {
  Ret visitX(X x);
  Ret visitY(Y y);
  Ret visitZ(Z z);
}

interface IFoo {
  <R> R accept(IFooVisitor<R> v);
}

class X implements IFoo {
  public <R> R accept(IFooVisitor<R> v) {
    return v.visitX(this);
  }
}

class Foo2IntVisitor implements IFooVisitor<Integer> {
  Integer visitX(X x) {
    // do something to x
  }
  Integer visitY(Y y);
  Integer visitZ(Z z);
  
  Integer apply(IFoo foo) {
    return foo.accept(this);
  }
}
```

