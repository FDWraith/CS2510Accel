### Lecture 19

```java
class ArrayUtils {
  <T,U> ArrayList<U> map(ArrayList<T> arr, IFunc<T,U> f) {
    ArrayList<U> result = new ArrayList<U>();
    for(T item : arr) {
      result.add(f.apply(item));
    }
    return result;
  }
}
```

