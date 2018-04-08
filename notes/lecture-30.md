### Lecture 30: Javascript

```javascript
"1234" == 1234 // Returns true
"1234" === 1234 // Returns false
```

`==` in javascript uses **coercion** to transforms values in order to compare each other

- Ex ```"1234"``` gets coerced to ```1234``` in order to compute statements/expressions

```javascript
function doubler(x) {
  return x + x;
}

doubler(2) --> 4
doubler(5) --> 10
doubler("5") --> "55"
doubler() --> NaN
doubler(3,4,5,6) --> 6
doubler({x:4, y:6}) --> "[object Object][object Object]"
```

**dynamic scope**: variables can be accessed from wherever they are defined (even if it is out of scope)

```javascript
// Constructors
function Posn(x,y) {
  this.x = x;
  this.y = y;
}

var myPosn = new Posn(3,4);
```

Inheritance or Prototyping

```javascript
var myPosn = {x: 3, y: 4}
var my3dPosn = {z: 12, __proto__: myPosn}
```

Overrides in Javascript

```javascript
// initially, my3dPosn has no x field, and relies on its proto for its x
my3dPosn.x --> 3
// setting it adds the x field
my3dPosn.x = 10
my3dPosn.x --> 10
// the prototype is unchanged
myPosn.x --> 3
```

Overrides also apply to calls to **```this```**

```javascript
function distToO() { return Math.sqrt(this.x * this.x + this.y * this.y); }
myPosn.distToO = distToO
myPosn.distToO() --> 5
my3dPosn.distToO() --> 10.77...
```

Meta Object Protocol -- underlying framework of dynamic classes / objects

```javascript
function Posn3d(x,y,z) { this.x = x; this.y = y; this.z = z; }
Posn3d.prototype = Object.create(Posn.prototype)
```

