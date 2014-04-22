package net.robstokes.demo.oldtricks

//references
// http://twitter.github.io/scala_school/type-basics.html
// http://twitter.github.io/scala_school/advanced-types.html


/*
covariant	      C[T’] is a subclass of C[T]	      [+T]
contravariant	  C[T] is a subclass of C[T’]	      [-T]
invariant	      C[T] and C[T’] are not related	  [T]
 */


class Generics {
  def generics() = {
    //covariance
    class Covariant[+A]
    val covariant: Covariant[AnyRef] = new Covariant[String]
    //val covariant1: Covariant[String] = new Covariant[AnyRef] //type mismatch

    class Contravariant[-A]
    val contravariant: Contravariant[String] = new Contravariant[AnyRef]
    //val fail: Contravariant[AnyRef] = new Contravariant[String] //type mismatch

    //Type Bounds
    def biophony[T <: Animal](things: Seq[T]) = things map (_.sound)
    biophony(Seq(new Chicken, new Bird))

    //List[B].::[B >: T](x: B)
    val listOfBirds = List(new Bird)
    val listOfAnimal = new Animal :: listOfBirds
    val flock : List[Bird] = List(new Bird, new Bird)
    val flock1 : List[Bird] =  new Chicken :: flock
    val flock2 : List[Animal] = new Animal :: flock
    //val flock2 : List[Bird] = new Animal :: flock //breaks
  }
}

class Animal { val sound = "rustle" }
class Bird extends Animal { override val sound = "call" }
class Chicken extends Bird { override val sound = "cluck" }

//invariance
class InvariantStack[T]{
  var elems: List[T] = Nil
  def push(x: T) { elems = x :: elems }
  def top: T = elems.head
  def pop() : T = {
    val result = elems.head
    elems = elems.tail
    result
  }
}



//View Bounds





