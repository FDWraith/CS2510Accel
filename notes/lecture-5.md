### Lecture 5

```java
interface IAT { 
  // to find the youngest grandparent in the ancestor tree
  IAT youngestGrandparent();
  // to determine if an ancestor tree "makes sense" (ie, all parents are older than their child)
  boolean isWellFormed();
  // to determine if an ancestor tree individual is born before a given year. 
  boolean bornBefore( int year );
  // to find the youngest individual in a given generation in the ancestor tree.
  IAT youngestInGen( int gen );
  // to pick the younger ancestor
  IAT youngerAnc( IAT other );
}

class Person implements IAT { 
  IAT mom;
  IAT dad;
  String name;
  int yob;
  
  Person( IAT mom, IAT dad, String name, int yob ) {
    this.mom = mom;
    this.dad = dad;
    this.name = name;
    this.yob = yob;
  }
  
  public boolean isWellFormed() { 
 	return this.mom.bornBefore( this.yob )
        && this.dad.bornBefore( this.yob )
        && this.mom.isWellFormed() 
        && this.dad.isWellFormed(); 
  }
  
  public boolean bornBefore( int year ) {
    return yob < year;
  }
  
  public IAT youngestInGen( int gen ) {
    if ( gen == 0 ) {
      return this;
    }else {
      momYoungest = this.mom.youngestInGen( gen - 1 );
      dadYoungest = this.dad.youngestInGen( gen - 1 );
      return momYoungest.youngerAnc( dadYoungest );
    }
  }
  
  public IAT youngerAnc( IAT other ) {
    if( other.bornBefore( this.yob ) ) {
      return this;
    }else{
      return other;
    }
  }
  
}

class Unknown implements IAT { 
  public boolean isWellFormed() {
    return true;
  }
  public boolean bornBefore( int year ) {
    return true;
  }
  public IAT youngestInGen( int gen ) {
    return this;
  }
  public IAT youngerAnc( IAT other ) {
    return other;
  }
}
```

Practice Problem from Lecture 8:

```java
interface IDoc { }

class Book implements IDoc {
  String authorFirstName;
  String authorLastName;
  String title;
  Bibliography bib;
  String publisher;
}

class Wiki implements IDoc {
  String authorFirstName;
  String authorLastName;
  String title;
  Bibliography bib;
  String url;
}

interface ILoDocument {
  
}

class ConsLoDocument implements ILoDocument { 
  IDoc first;
  ILoDocument rest;
}

class MtLoDocument implements ILoDocument { 
  
}

class Bibliography { 
  ILoDocument documents;
}
```

