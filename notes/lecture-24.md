### Lecture 24

```java
interface IDict<K,V> {
  V lookup(K key);
  void put(K key, V val);
}
```

#### Hashtable

- Summarize the `key` to a small number (this is called hashing)
- Store the `value` at the summary index of an `ArrayList`
- In the event of a collision:
  - **Rehashing**: Make another hashtable at the index
  - **Linear Probing**: Search for another valid index
  - **Open chaining**: Make a list at the index

#### Hashcode Rules

- If ``x.equals(y)`` then ``x.hashCode() == y.hashCode()``
- If `x.equals(y) == false` then `x.hashCode() ?? y.hashCode()`



