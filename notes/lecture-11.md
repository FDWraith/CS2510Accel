### Lecture 11: Generics

```java
interface IBookPred {
  boolean matches(Book b);
}
interface IRectPred {
  boolean matches(Rectangel r);
}
```

Generic Version

```java
interface IPred<T> {
  boolean matches(T t);
}
```

Applying Generics to ```IList```

```java
interface IList<T> { 
  IList<T> filter(IPred<T> pred); 
}
class MtList<T> implements IList<T> { }
class ConsList<T> implements IList<T> {
  T first;
  IList<T> rest;
}
```

Example

```java
IList<String> strs = new ConsList<String>("hi", new MtList<String>());
```

**T** must be an Object-type (primitives are excluded). To use Generics with primitives, you have to use the ```Integer```, ```Double``` and ```Boolean``` classes.

Designing Map and Foldr

```java
interface IFunc<T,S> {
  S apply(T t);
}

interface IFunc2<R,A1,A2> {
  R apply(A1 a1, A2 a2);
}

interface IList<T> {
  <S> IList<S> map(IFunc<T,S> func);
  <S> S foldr(IFunc2<S,T,S> func, S start); 
}

class ConsList<T> implements IList<T> {
  T first;
  IList<T> rest;
  
  public <S> IList<S> map(IFunc<T,S> func) {
    return new ConsList<S>(func.apply(this.first), this.rest.map(func));
  }
}

class MtList<T> implements IList<T> {
  public <S> IList<S> map(IFunc<T,S> func) {
    return new MtList<S>();
  }
}
```

Example of Using these Abstractions

```java
IList<String> strs = new ConsList<String>("hi", new MtList<String>());

//function object
class strLens implements IFunc<String, Integer> {
  Integer apply(String s) {
    return s.length()
  }
}

IList<Integer> strsLengths = strs.map(new strLens());
// This creates a list the size of strs, but with each element as an Integer representing the length of the original string.
// IE: (list "hi")  --> (list 2)
//     (list "hi" "wow" "okay") --> (list 2 3 4)
```

```java
IList<IShape> shapes = new ConsList<IShape>(new Circle(...),
                       new ConsList<IShape>(new Square(...),
					   new MtList<IShape>()));
IList<Circle> circles = new ConsList<Circle>(new Circle(...), new MtList<Circle>());
IList<IShape> moreshapes = circles; // This does not work
```

