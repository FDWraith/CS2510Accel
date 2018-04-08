### Lecture 26

Priority Queue

- First in, most important out
- `PriQ<T extends <Comparable<T>>`

Binary Heap for Priority Queue

- Max Heap Invariant (max is at the root of the tree)

- Fullness Invariant (tree is full, and extras are shoved to the left of the tree)

- ```
     			                  80
     		    			  /  	   \
                              60		    50
                            /    \     /    \
                           30     50  40    20
                          /  \   /
                         10  20 15	
     ```

- To implement insertion:

     - insert at the bottom-most, left-most position
     - swap upwards through the heap, until the Max Heap Invariant is satisfied

- To implement removal:

     - remove the top-most element
     - put the bottom-most, right-most item at the top of the heap
     - swap downward through the heap, until the Max Heap Invariant is satisfied

Heapsort

- Build Heap --> $O(n \log(n))$
- Wreck Heap --> $O(n \log(n))$ 

