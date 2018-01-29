### Lecture 9

Notions of Equality:

- Two objects are same **if** pieces are the same

- Reflexivity, Symmetry, Transitivity, and Totality:

- $$
  \forall x, x = x 
  \\
  \forall x,y  \ \ \ x = y <=> y = x
  \\
  \forall x,y,z  \ \ \ x = y  \ \& \ y = z \ => x = z
  \\
  can \ check \ x = y \ for \ all \ x,y
  $$

- Observational Equivalance: 

  - Two objects are the same **if**  you replace one object with another, and the behavior is unchanged

```java
class Book {
  String title;
  Author auth;
  
  // Determines if this book is the same as the other book
  boolean sameBook(Book other) {
      return title.equals(other.title) && this.auth.sameAuthor(other.auth);    
  }
}

class Author {
  String firstName;
  String lastName;
  
  boolean sameAuthor(Author other) {
    return this.firstName.equals(other.firstName) && this.lastName.equals(other.lastName);
  }
}
```

Equality as Demonstrated in Union Data using ```instanceof```.

```java
interface IShape {
  // determines if this shape is the same as the other shape
  boolean sameShape(IShape other);
}

class Circle implements IShape {
  int radius;
  
  public boolean sameShape(IShape other) {
    if (!(other instanceof Circle)) {
      return false;
    } else {
      Circle other = (Circle)(other);
      return this.radius == other.radius; 
    }
  }
}

class Rectangle implements IShape {
  // blah
}

class Square extends Rectangle {
  int size;
  
  public boolean sameShape(IShape other) {
    if (!(other instanceof Square)) {
      return false;
    } else {
      Square other = (Square)(other);
      return this.size == other.size;
    }
  }
}
```

Another approach:

```java
interface IShape {
  // determines if this shape is the same as the other shape
  boolean sameShape(IShape other);
  boolean sameCircle(Circle other);
  boolean sameRect(Rectangle other);
  boolean sameSquare(Square other);
}

class Circle implements IShape {
  int radius;
  
  public boolean sameShape(IShape other) {
	return other.sameCircle(this);	
  }
  public boolean sameCircle(Circle other) {
    return this.radius == other.radius;
  }
  public boolean sameRect(Rectangle other) {
    return false;
  }
  public boolean sameSquare(Square other) {
    return false;
  }
}

class Rectangle implements IShape {
  int width;
  int height;
  
  public boolean sameShape(IShape other) {
    return other.sameRect(this);
  }
  public boolean sameCircle(Circle other) {
    return false;
  }
  public boolean sameRect(Rectangle other) {
    return this.width == other.width && this.height == other.height;
  }
  public boolean sameSquare(Square other) {
    return false;
  }
}

class Square extends Rectangle {
  int size;
  
  public boolean sameShape(IShape other) {
    return other.sameSquare(this);
  }
  public boolean sameCircle(Circle other) {
    return false;
  }
  public boolean sameRect(Rectangle other) {
    return other.sameSquare(this);
  }
}
```

Here, information is *accumulated* by calling out the helper methods that keep track of the original data type. This is known as **double dispatch**.

