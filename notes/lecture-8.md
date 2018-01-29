### Lecture 8

**Overloading**: Defining two or more methods / constructors of the same name where the arguments are sufficiently different that they cannot be confused with each other.

```java
class ComplexNum {
  double real;
  double imag;
  
  ComplexNum(double r, double i) {
    this.real = r;
    this.imag = i;
  }
  
  // Overloading
  ComplexNum(double r) {  // Convenience Constructor
    this.real = r;
    this.imag = 0;
  }
  
  // Alternatively
  ComplexNum(double r) {
    this(r,0);
  }
}
```

```java
interface IAT { 
  boolean bornBefore(int);
}

class Person implements IAT {
  String name;
  int yob;
  IAT mom;
  IAT dad;
  
  Person(String name, int yob, IAT mom, IAT dad) {
    if (!(mom.bornBefore(yob) && dad.bornBefore(yob))) {
      throw new IllegalArgumentException("bad yob");
    } else {
      // initialize as normal
    }
  }
}
```

**Constants** in Java

```java
interface IGameBoard {
  int DEFAULT_WIDTH = 20;
}
```

Checking Constructor Exception

```java
t.checkConstructorException(new IllegalArgumentException("bad yob"),
                            "Person",
                            "Oldie",0,young,young);
```

