```java
interface IPred<T> {
  
  // T is an object
 
  boolean ask(T t); // t is of type-T
}

interface IConvert<T> {
  T apply(T t);
}

interface IConvert2<T, R> {
  R apply(T t);
}

class RectToInt implements IConvert2<Rectangle, Integer> {
   Integer apply(Rectangle r) {
     return r.size;
   }
}

interface IList<T> {
  IList<T> filter(IPred<T> p);
  <R> IList<R> map(IConvert2<T,R> p);
}

class Cons<T> implements IList<T> {
  
  IList<T> filter(IPred<T> p) {
    if (p.ask(this.first)) {
      return new Cons<T>(this.first, this.rest.filter(p));
    } else {
      return this.rest.filter(p);
    }
  }
  
  <R> IList<R> map(IConvert2<T,R> p) {
    return new Cons<T>(p.apply(this.first), this.rest.map(p));
  }
}

class Empty<T> implements IList<T> {
  IList<T> filter(IPred<T> p) {
    return this;
  }
  
  <R> IList<R> map(IConvert2<T,R> p) {
    return this;
  }
}
```

