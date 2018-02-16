### Lecture 16

```java
interface IPred<T> {
  // applies a method to T, to check a property of T
  boolean apply(T);
}

interface IList<T> {
  // finds the first instance of T in the list that matches the pred
  T find(IPred<T> pred);
  // modifies the first instance of T in the list that matches pred 
  // by applying app to that T
  void modify(IPred<T> pred, IFunc<T,Void> app);
  // removes the first instance of T in the list that matches pred
  T remove(IPred<T> pred);
  // ACCUMULULATOR: prev represents the previous item in the list
  T remove(IPred<T> pred, Cons<T> prev);
}

class ANode<T> implements IList<T> {
  IList<T> rest;
}

class Cons<T> extends ANode<T> {
  T first;
  
  public T find(IPred<T> pred) {
    if (pred.apply(this.first)) {
      return this.first;
    } else {
      return this.rest.find(pred);
    }
  }
  
  
  public void modify(IPred<T> pred, IFunc<T,Void> app) {
    if (pred.apply(this.first)) {
      app.apply(this.first);
    } else {
      this.rest.modify(pred,app); 
    }
  }
  
  public T remove(IPred<T> pred) {
    
    // return this.remove(pred, this);
  }
  
  public T remove(IPred<T> pred, Cons<T> previous) {
    if (pred.apply(this.first)) {
      previous.rest = this.rest;
      return this.first;
    } else {
      return this.rest.remove(pred, this);
    }
  }
}

class Sentinel<T> extends ANode<T> {
  // dummy header
}

class Empty<T> implements IList<T> {
  // returns null, so it is important to check before calling any methods
  public T find(IPred<T> pred) {
  	return null;
  }
  
  public void modify(IPred<T> pred, IFunc<T,Void> app) {
    // do nothing
  }
  
  public T remove(IPred<T> pred) {
    return null;
  }
} 
```

For user interaction:

```java
class MutableList<T> {
  Sentinel<T> list;
  
  T remove(IPred<T>);
  void modify(...);
  void addToFront(T t);
  void addToBack(T t);
  MutableList<U> map(IFunc<T,U>);
  int length();
  T get(int index);
  void set(int index, T val);
  boolean contains(IPred<T>);
  void insertAt(int index, T);
}
```

