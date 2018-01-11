### Lecture 3

```lisp
;; A FamTree is one of:
;;  - (make-person String FamTree FamTree)
;;  - 'unknown
```

Implemented in Java:

```java
interface IFamTree { 
  // counts # of known anc. of this FamTree
  int countKnownAncestors();
  // counts # of persons in this Person
  int countPersons();
}
class Person implements IFamTree { 
  String name;
  int yob;
  IFamTree mother;
  IFamTree father;
  
  Person( String name, int yob, IFamTree mother, IFamTree father ) { 
  	this.name = name;
    this.yob = yob;
    this.mother = mother;
    this.father = father;
  }
  
  // counts # of Persons in this Person
  public int countPersons() { 
  	return 1 + this.mother.countPersons() 
             + this.father.countPersons();
  }
  
  // counts # of Ancestors in this Person
  public int countKnownAncestors() {
    return this.countPersons() - 1;
  }
}

class Unknown implements IFamTree { 
  // counts # of Persons in this Unknown
  public int countPersons() {
    return 0;
  }
  
  // counts # of Ancestors in this Unknown
  public int countKnownAncestors() {
    return 0;
  }
}

class ExamplesFamTree { 
  IFamTree unknown = Unknown();
  IFamTree grandma = Person( "grandma", 1930, unknown, unknown );
  IFamTree greatGrandpa = Person( "great grandpa", 1890, unknown, unknown );
  IFamTree grandpa = Person( "grandpa", 1931, unknown, greatGrandpa );
  IFamTree mom = Person( "mom", 1970, grandma, grandpa );
  IFamTree dad = Person( "dad", 1965, unknown, unknown );
  IFamTree me = Person( "me", 1999, mom, dad );
  
  boolean testCountKnownAncestors( Tester t ) {
 	return t.checkExpect( unknown.countKnownAncestors(), 0 )
      &&   t.checkExpect( grandma.countKnownAncestors(), 0 )
      &&   t.checkExpect( grandpa.countKnownAncestors(), 1 )
      &&   t.checkExpect( mom.countKnownAncestors(), 3 )
  }
}
```

Template Construction in Java:

```java
/*
Fields:
	this.name - String
	this.yob - int
	this.mother - FT
	this.father - FT
Methods:
	this.countPersons() - int
	...
Methods on Fields:
	this.mother.countPersons() 
	this.father.countPersons()
    ...
*/
```

**Dynamic Dispatch** -- Choice of function / method being used is done at runtime.



