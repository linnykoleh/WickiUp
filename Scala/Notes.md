
- `sbt console` - run scala in command line

- `var` - mutable value
```scala
var a : Int = 12;
var aa  = 12;

```

- `val` - immutable value, constant
```scala
val b : Int = 50
val bb = 50

```

- {} expressions

```scala 
val x = {
     | val a = 400
     | val b = 500
     | a + b
     | }
x: Int = 900
```

- lazy initialization. Assign in memory when need, use

```scala
lazy val x = 500
```
x: Int = <lazy>


