### Lecture 23

```java
for(T elem : seq) {
  ...
}
```

is equivalent to

```java
Iterator iter = seq.iterator();
while(iter.hasNext()) {
  T elem = iter.next();
  ...
}
```

As a result, there are two interfaces that need to be implemented to use in the for-each loop

```java
interface Iterator<T> {
  // determines if there is a next element
  boolean hasNext();
  
  // returns the next value, and moves the cursor forward
  T next();
}

interface Iterable<T> {
  // returns an iterator
  Iterator<T> iterator();
}
```

Implementing an ArrayList iterator:

```java
class ALIterator<T> implements Iterator<T> {
  ArrayList<T> source;
  int indexForNext;
  
  ALIterator(ArrayList<T> source) {
    if (source == null) {
      throw new InvalidArguementException("Bad");
    }
    this.source = source;
    this.indexForNext = 0;
  }
  
  public boolean hasNext() {
    return this.indexForNext < this.source.size();
  }
  
  public T next() {
    if (!this.hasNext()) {
      throw new IllegalStateException(...);
    }
    T ans = this.source.get(this.indexForNext);
    this.indexForNext += 1;
    return ans;
  }
}
```

Implementing IList iterator

```java
class IListIterator<T> implements Iterator<T> {
  IList<T> curr; // this gets modified
  
  IListIterator(IList<T> source) {
    this.curr = source;
  } 
  
  public boolean hasNext() {
    return this.curr instanceof Cons;
  }
      
  public T next() {
    if (!this.hasNext()) {
      throw new IllegalStateException(...);
    }
    T ans = ((Cons<T>)this.curr).first;
    this.curr = ((Cons<T>)this.curr).rest; 
    return ans;
  }
}
```

single line class declarations:

```java
for(T elem : new Iterable() {public Iterator<T> iterator() { return new IListIterator<T>(...); }})
```

every other item

```java
class EveryOther<T> implements Iterator<T> {
  Iterator<T> source;
  
  public boolean hasNext() {
    return this.source.hasNext();
  }
  
  public T next() {
    if (!this.hasNext()) {
      throw new IllegalStateException(...);
    }
    T ans = this.source.next();
 	if (this.source.hasNext()) {
      this.source.next();
 	}
    return ans;
  }
}
```

```java
class BinTreeIter<T> implements Iterator<T> {
  
}
```

