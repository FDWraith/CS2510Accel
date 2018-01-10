import tester.*;

// to represent a geometric shape
interface IShape { }

// to represent a circle
class Circle implements IShape {
    int x;
    int y;
    int rad;

    Circle(int x, int y, int rad) {
        this.x = x;
        this.y = y;
        this.rad = rad;
    }
}

// to represent a rectangle
class Rect implements IShape {
    int x;
    int y;
    int w;
    int h;

    Rect(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}

// to represent a combined shape
class Combo implements IShape {
    IShape top;
    IShape bot;

    Combo(IShape top, IShape bot) {
        this.top = top;
        this.bot = bot;
    }
}

// to represent examples and tests for shapes
class ExamplesShapes {

    IShape circle = new Circle(50, 50, 50);
    IShape rleft = new Rect(20, 20, 20, 20);
    IShape rBot = new Rect(20, 60, 60, 20);

    IShape addMouth = new Combo(this.rBot, this.circle);
    IShape addLeftEye = new Combo(this.rleft, this.addMouth);
    IShape face = new Combo(new Rect(60, 20, 20, 20), this.addLeftEye);
    
}

// to represent an address
class Address {
	String city;
	String state;
	
	Address( String city, String state ) {
		this.city = city;
		this.state = state;
	}
}

// to represent a person
class Person {
	String name;
	int age;
	String gender;
	Address address;
	
	Person( String name, int age, String gender, Address address ) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
}

// to represent examples and tests of people
class ExamplesPerson {
	
	Person tim = new Person( "Tim", 20, "M", new Address("Warwick", "RI"));
	Person pat = new Person( "Pat", 19, "F", new Address("Boston", "MA"));
	Person kim = new Person( "Kim", 17, "F", new Address("Boston", "MA"));
	Person dan = new Person( "Dan", 22, "M", new Address("Nashua", "NH"));
}

// to represent a deli item
interface IDeliItem { }

// to represent Soups
class Soup implements IDeliItem {
	boolean vege;
	String name;
	int price;
	
	Soup( String name, int price, boolean vege ) {
		this.name = name;
		this.price = price;
		this.vege = vege;	
	}
}

//to represent Salad
class Salad implements IDeliItem {
	String dressing;
	boolean vege;
	String name;
	int price;
	
	Salad( String name, int price, boolean vege, String dressing ) {
		this.name = name;
		this.price = price;
		this.vege = vege;	
		this.dressing = dressing;	
	}
}

//to represent two fillings
class Fillings {
	String fillingA;
	String fillingB;
	
	Fillings( String fillingA, String fillingB ) {
		this.fillingA = fillingA;
		this.fillingB = fillingB;
	}
}

//to represent sandwich
class Sandwich implements IDeliItem {
	String bread;
	Fillings fillings;
	String name;
	int price;
	
	Sandwich( String name, int price, String bread, Fillings fillings ) {
		this.name = name;
		this.price = price;
		this.bread = bread;
		this.fillings = fillings;	
	}
}

// to represent the examples of deli items
class ExamplesDeliItems {
	
	IDeliItem soupA = new Soup( "soupA", 100, true );
	IDeliItem soupB = new Soup( "soupB", 200, false );
	
	IDeliItem saladA = new Salad( "saladA", 200, false, "cream cheese" );
	IDeliItem saladB = new Salad( "saladB", 200, false, "mayo" );
	
	IDeliItem sandwichA = new Sandwich( "sA", 200, "wheat", new Fillings("ham", "cheese"));
	IDeliItem sandwichB = new Sandwich( "sB", 500, "italian", new Fillings("beef", "jelly"));
	
}

// to represent a node on the AncestorTree
interface IAncestorTreePerson { }

// to represent unknown
class Unknown implements IAncestorTreePerson { 
	Unknown(){ }
}

// to represent an ancestor tree
class AncestorTree implements IAncestorTreePerson {
	
	Person current;
	IAncestorTreePerson left;
	IAncestorTreePerson right;
	
	AncestorTree( Person current, IAncestorTreePerson left, IAncestorTreePerson right) {
		this.current = current;
		this.left = left;
		this.right = right;
	}
}

// to represent examples for ancestor trees
class ExamplesAT {
	
	IAncestorTreePerson unknown = new Unknown();
	Person tim = new Person( "Tim", 20, "M", new Address("Warwick", "RI"));
	Person pat = new Person( "Pat", 19, "F", new Address("Boston", "MA"));
	Person kim = new Person( "Kim", 17, "F", new Address("Boston", "MA"));
	Person dan = new Person( "Dan", 22, "M", new Address("Nashua", "NH"));
	
	IAncestorTreePerson t0 = new AncestorTree( pat, unknown, unknown );
	IAncestorTreePerson t1 = new AncestorTree( tim, unknown, t0);
	IAncestorTreePerson t2 = new AncestorTree( dan, t1, unknown);
	IAncestorTreePerson t3 = new AncestorTree( kim, unknown, t2);
}




