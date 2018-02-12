### Lecture 13

```java
class Book {
  String title;
  Author author;
}

class Author {
  String name;
  Book book;
}

class ExamplesBooks {
  Book b = new Book("HtDP", new Author("Matthias", this.b));
  // Step 1: Declare b exists, with null placeholder value
  // Step 2: Evaluate this.b to null
  // Step 3: Evaluate constructor for Author
  // Step 4: Evaluate constructor for Book
  // Step 5: Assign constructed Book to b
  
  // Issue: Step 2 is evaluated too early.
  // Failing Test: 
  t.checkExpect(b.author.book.title, "HtDP");
}
```

In order to fix this

```java
class ExamplesBooks {
  Book b = new Book("HtDP", new Author("Matthias", null)); // clear to reader
  b.author.book = b; // this assigns b to the author's book
}
```

