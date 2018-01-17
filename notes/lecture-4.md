### Lecture 4

List Data represented in Java

```java
class Book {
  String author;
  String title
  Book( String author, String title ) {
    this.author = author;
    this.title = title;
  }
  
  public int compareTo( Book other ) {
    return this.author.compareTo( other.author );
  }
}

interface ILoBook { 
  ILoBook sortByAuthor();
  ILoBook insertSortedByAuthor( Book b );
  ILoBook reverse();
  ILoBook revAcc( ILoBook soFar );
}

class ConsLoBook implements ILoBook {
  Book first;
  ILoBook rest;
  
  public ILoBook sortByAuthor() {
    return this.rest.sortByAuthor()
                    .insertSortedByAuthor( this.first );
  }
  public ILoBook insertSortedByAuthor( Book b ) {
  	compareValue = this.first.compareTo( b );
    if( compareValue >= 0 ) {
      return new ConsLoBook( b, this ); 
    } else {
      return new ConsLoBook( this.first, this.rest.insertSortedByAuthor(b) );
    }
  }
  public ILoBook reverse() {
    return this.revAcc( new MtLoBook );
  }
  public ILoBook revAcc( ILoBook soFar ) {
    return this.rest.revAcc( new ConsLoBook(this.first, soFar) );
  }
}

class MtLoBook implements ILoBook {
  public ILoBook sortByAuthor() {
    return new MtLoBook();    
  }
  public ILoBook insertSortedByAuthor( Book b ) {
    return new ConsLoBook( b, new MtLoBook() );
  }
  public ILoBook reverse() {
    return this;
  }
  public ILoBook revAcc( ILoBook soFar ) {
    return soFar;
  }
}

// Added On
class SnocLoBook implements ILoBook { 
  ILoBook front;
  Book last;
  public ILoBook reverse() {
    return new ConsLoBook( this.last, this.front.reverse() );
  }
  public ILoBook revAcc( ILoBook soFar ) {
    return new AppendLoBook( this.reverse(), soFar );
    // Alternative Solution:
    return new ConsLoBook( this.last, this.front.revAcc(soFar) );
  }
}

class AppendLoBook implements ILoBook {
  ILoBook front;
  ILoBook back;
  
}
```

Adding definitions of ```Append``` and ```Snoc``` simplifies some methods, such as ```reverse()```. This is akin to expanding your language. 

 