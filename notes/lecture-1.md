## Lecture 1

Java has:

- Integers (ex. -1, 1, 0)
- Doubles (ex. #i 1.1)
- Booleans (ex. true, false)
- Strings (ex. "Hello World")
- Characters (ex. 'a', 'b')

Defining variables in Java:

```java
int temp = -1;
double val = 0.3;
boolean yup = true;
String msg = "Hello World";
```

Sample Structs ( Class Diagram )

```java
//Posn
int x;
int y;

//Message
String body;
Person sender;
Person receiver;

//Person
String name;
int id;
```

Translated to Java:

```java
class Posn{
  int x; 
  int y;
  
  Posn( int x, int y ){
    this.x = x;
    this.y = y;
  }
}

class Message{
  String body;
  Person sender;
  Person receiver;
  
  Message( String body, Person sender, Person receiver ){
    this.body = body;
    this.sender = sender;
    this.receiver = receiver;
  }
}

class Person{
  String name;
  int id;
  
  Person( String name, int id ){
    this.name = name;
    this.id = id;
  }
}
```

Instantiated:

```java
Posn p1 = new Posn(temp, 3);
Message memo = new Message("In class now!", me, me);
Person me = new Person("Lerner", 42);
```

Methods:

```java
//In Posn
double distToOrigin(){
	return Math.sqrt( this.x * this.x + this.y * this.y );
}
```



