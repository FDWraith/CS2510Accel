### Lecture 27

```java
void heapify(ArrayList<T> arr) {
  // after i iterations, arr has been modified to a Max Heap
  for(int index = 0; index < arr.size(); index += 1) {
    upheap(arr,index);
  }
  // alternative option
  for(int index = arr.size()/2, index >= 0; index -= 1) {
    downheap(arr,index);
  }
}
```

Navigating a graph

```java
class Vertex {
  Deque<Edge> outEdges
}

class Edge {
  Vertex from, to;
  int weight;
}

class Graph {
  Deque<Vertex> vertices;
  
  boolean hasPath(Vertex from, Vertex to) {
    Queue<Vertex> workList = new Queue<Vertex>();
    Deque<Vertex> seen = new Deque<Vertex>(); 
    workList.enqueue(from);
    
    while(!workList.isEmpty()) {
      Vertex curr = workList.dequeue();
      if (curr.equals(to)) { 
        return true; 
      } else if (!seen.contains(curr)) {
	      for (Edge next : curr.outEdges) {
    	    workList.enqueue(next.to);
      	  }	
      	seen.add(curr);
      }
    }
    
    return false;
  }
}
```

