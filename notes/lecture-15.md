### Lecture 15

```java
Unknown u1 = new Unknown();
Amobea a1 = new Amobea(u1, u1);
       a2 = new Amobea(a1, a1);
       a3 = new Amobea(a2, a2);
       a4 = new Amobea(a3, a3);
```

To Test Side Effects:

1. Set up prisitine initial conditions
2. Wreck it
3. Test the wreckage

```java
Book b1, b2
// initialize the data
void initData() {
  // Setups a test fiture
  Book b1 = ...;
  Book b2 = ...;
  t.checkExpect(b1.author != b2.author, true)
}
void testSetAuthor(Tester, t) {
  b1.author = b2.author;
  t.checkExpect(b1.author.book == b2.author.book, true);
}
```

```java
Person anne = Person("Anne", 1234);
Person bob = Person("Bob", 3456);
Person clyde = Person("Clyde", 6789);
Person dave = Person("Dave", 1357);
Person eric = Person("Eric", 12469);
Person frank = Person("Frank", 7294);
Person gail = Person("Gail", 9345);
Person henry = Person("Henry", 8602);
Person irene = Person("Irene", 91302);
Person jeremy = Person("Jeremy", 82232);

IList<Person> friends = IList(anne, clyde, gail, jeremy);
IList<Person> family = IList(anne, dave, frank);
IList<Person> coworkers = IList(bob, clyde, dave, eric, henry, irene);
```

