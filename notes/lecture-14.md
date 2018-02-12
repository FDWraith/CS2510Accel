###  Lecture 14:bride_with_veil:

```java
class Examples {
  Author a = new Author("MF", null);
  Book b = new Book("HtDP", a);
  
  Examples() {
    b.author.book = b;
  }
  
  boolean testAuthor(Tester t) {
    t.checkExpect(a.book.author, a);
  }
```

Alternatively

```java
class Book {
  Book(String title, Author a) {
    this.title = title;
    this.author = a;
    this.author.book = this;
  }
}
```

```java
class Counter {
  int val
  Counter (int init) {
    this. val = init
  }
  
  // EFFECT: modifies this.val
  int next() {
    int cur = this.val;
    this.val = this.val + 1;
    return cur;
  }
}
```

