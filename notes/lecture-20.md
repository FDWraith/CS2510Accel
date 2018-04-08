### Lecture 20

```java
class ArrayUtils {
  
  // converts the input list of type T to a list of type U by 
  // applying mapFunc to each item in the input list.
  <T,U> ArrayList<U> map(ArrayList<T> input, IFunc<T,U> mapFunc) {
    ArrayList<U> result = new ArrayList<U>();
    for(T item: input) {
      result.add(mapFunc.apply(item));
    }
    return result;
  }
  
  // EFFECT: sort the given list in place
  void sort(ArrayList<String> strs, int curIdx) {
    if (curIdx >= strs.size()) { return; }
    int smallestIdx = findMin(curIdx, strs);
    swap(strs, smallestIdx, curIdx);
    sort(strs, curIdx + 1);
  }
  
  // Finds index of smallest Value
  int findMin(int startIndex, ArrayList<String> strs) {
    
  }
  
  // EFFECT: modifies array to exchange two
  <T> void swap(ArrayList<T> arr, int source, int dest) {
    T temp = arr.get(source);
    arr.set(source, arr.get(dest));
    arr.set(dest, temp);
  }
  
}
```

**for-each loops:**

- not allowed to modify the list you are looping over (ie: removing items, changing length of list)

**for loops**:

```java
for(int curIndex = <start value>; curIndex <endValue>; curIndex +=1) {
  // do stuff
}
```

