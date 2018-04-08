### Lecture 21

```java
class ArrayUtils {
  <T,R> ArrayList<R> map(ArrayList<T> src, IFunc<T,R> mapFunc) {
    ArrayList<R> result = new ArrayList<R>();
    // processes each item in turn, grows result
    for (T item : src) {
      result.add(mapFunc.apply(item));
    }
    return result;
  }
  
  <T> void transform(ArrayList<T> arr, IFunc<T,T> f) {
    for (T item : arr) {
      f.apply(item);
    }
  }
    
  // Builds a list of length len, with each item corresponding to itemFunc applied to its index (from 0 to len - 1)
  <T> ArrayList<T> buildList(Integer len, IFunc<Integer,T> itemFunc) {
  	ArrayList<T> result = new ArrayList<T>();
    
    // generates a new item for each index, grows result 
    for (int index = 0; i < len; index += 1) {
      result.add(itemFunc.apply(index));
    }
    return result;
  }
  
  <T> T search(ArrayList<T> src, IPred<T> p);
  
  <T> void sort(ArrayList<T> src, IComparator<T> comp) {
    // all items from 0 up to index are sorted and less than remainding items 
    for(int index = 0; index < src.size(); index += 1) {
      int minDex = minIndex(src, index, comp);
      swap(src, index, minDex);
  	}
  }
  
  <T> int minIndex(ArrayList<T> src, int startIndex, IComparator<T> comp) {
    int minSoFar = startIndex;
    
    // minSoFar is the index of the smallest T in the range [startIndex, index)
    for (int index = startIndex + 1; index < src.size(); index += 1) {
      if (comp.compare(src.get(index), src.get(minSoFar)) < 0) {
        minSoFar = index;
      }
    }
    return minSoFar;
  }
  
  
}
```

