###Lecture 31

```java
class Person {
  public String name;
  protected String city;
  private int age;
  
  public boolean isBostonian() {
    return this.city.equals("Boston");
  }
}

class Employee extends Person {
  private int wage;
  
  Employee(String name, String city, int age, int wage) {
    super(name, city, age);
    this.wage = wage;
  }
}
```

``protected`` is a field that is visible to a class and its sub-classes

``private`` is a field that is only visible to a single class

``public`` is a field that is visible anywhere

interfaces are, by default, ``public``

```java
public interface IList<T> {
  int length();
}

abstract class AList<T> implements IList<T> {
  public int length() {
    return this.lengthAcc(0);
  }
  
  protected abstract int lenghtAcc(int acc);
}

public class Cons<T> extends AList<T> {
  protected int lengthAcc(int acc) {
    return this.rest.lengthAcc(acc + 1);
  }
}

public class Empty<T> extends AList<T> {
  private T first;
  private AList<T> rest;
  
  protected int lengthAcc(int acc) {
    return acc;
  }
}
```

