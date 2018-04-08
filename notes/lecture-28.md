### Lecture 28

```java
boolean hasPath(Vertex from, Vertex to) {
  seen = new ArrayList<Vertex>();
  worklist = new Queue<Vertex>();
  worklist.enqueue(from);
  while(!worklist.isEmpty()) {
    next = worklist.dequeue();
    if (next == to) return true;
    if (!seen.contains(next)) {
      for (Edge e : next.edges) {
        worklist.add(e.to);
      }
    }
  }
}

// converted into an iterator

class BFSIterator implements Iterator<Vertex> {
  ArrayList<Vertex> seen;
  Queue<Vertex> worklist;
  
  BFSIterator(Vertex from) {
    seen = new ArrayList<Vertex>();
    worklist = new Queue<Vertex>();
    worklist.enqueue(from);
  }
  
  public boolean hasNext() {
    return !worklist.isEmpty();
  }
  
  public Vertex next() {
    Vertex ans = worklist.deque();
    seen.add(ans);
    for (Edge e : ans.edges()) {
      if (!seen.contains(e.to)) {
        worklist.enqueue(e.to);
      }
    }
    return ans;
  }
}


// applying this iterator to previous problem
boolean hasPath(Vertex from, Vertex to) {
  Iterator<Vertex> reachable = new BFSIterator(from);
  while (reachable.hasNext()) {
    if (reachable.next() == to) {
      return true;
    }
  }
  return false;
}
```



