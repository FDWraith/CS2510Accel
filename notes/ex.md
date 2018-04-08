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
    return new Cons<R>(p.apply(this.first), this.rest.map(p));
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

#### Double Dispatch

````java
interface IList<T> {
  
  // removes all the items in this list that are in other
  // and returns the resulting list. 
  IList<T> removeMatching(ITree<T> other);
  
  // traverses other and replaces node values with values
  // from this list, beginning with the left branch
  // when the left branch is filled, the right branch is
  // then filled.
  // Returns the resulting tree
  ITree<T> replaceItems(ITree<T> other);
} 

class MtList<T> implements IList<T> {
  IList<T> removeMatching(ITree<T> other) {
    return new MtList<T>();
  }
  
  ITree<T> replaceItems(ITree<t> other) {
    return other;
  }
}

class ConsList<T> implements IList<T> {
  T first;
  IList<T> rest;
  
  ConsList(T first, IList<T> rest) {
     this.first = first;
     this.rest = rest;
  }
  
  IList<T> removeMatching(ITree<T> other) {
    if (other.foundItem(this.first)) {
      return this.rest.removeMatching(other);
    } else {
      return new ConsList(this.first, this.rest.removeMatching(other));
    }
  }
  
  ITree<T> replaceItems(ITree<t> other) {
    return other.left.replaceWith(this);
  }
  
}

interface ITree<T> {
  boolean foundItem(T item);
  ITree<T> replaceWith(IList<T> list);
}

class Leaf<T> implements ITree<T> {
  boolean foundItem(T item) {
    return false;
  }
  
  ITree<T> replaceWith(IList<T> list) {
    return this;
  }
}

class Node<T> implements ITree<T> {
  T val;
  ITree<T> left;
  ITree<T> right;
  
  Node(T val, ITree<T> left, ITree<T> right) {
    this.val = val;
    this.left = left;
    this.right=  right;
  }
  
  boolean foundItem(T item) {
    if (this.val.equals(item)) {
      return true;
    } else {
      return this.left.foundItem(item) || this.right.foundItem(item);
    }
  }
  
  ITree<T> replaceWith(IList<T> list) {
    T listVal = list.first;
    IList<T> rest = list.rest;
    Node<T> newNode = new Node<T>(listVal, this.left, this.right);
    return newNode.
  }
  
}
````

