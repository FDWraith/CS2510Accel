### Lecture 29: Minimum Spanning Tree

```
A ----30--- B ---50---- C
 \        / |          /
  \   40 /  |         / 
20 \    /   | 50     / 90
    \  /    |       /
     D--70--E--10--F 
```

- minimum spanning tree optimizes for the whole tree, not for any local path
- To make a MST
  - sort edges
  - for each edge, if not cycle, use edge

```
Node: [A B C D E F]
Blob: [A B C D E F]
            |
            EF
            |
Node: [A B C D E F]
Blob: [A B C D E E]
            |
            AD
            |
Node: [A B C D E F]
Blob: [A B C A E E]
            |
            AB
            |
Node: [A B C D E F]
Blob: [A A C A E E]
            |
            BE
            |
Node: [A B C D E F]
Blob: [A A C A A E]
            |
            BC
            |
Node: [A B C D E F]
Blob: [A A A A A E]
```

Union-Find data structure:

- only allows for union and find operations

```java
class Node {
  Node parent;
}
```



