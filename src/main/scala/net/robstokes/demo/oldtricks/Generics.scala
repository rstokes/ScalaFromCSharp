package net.robstokes.demo.oldtricks

//reference: http://twitter.github.io/scala_school/type-basics.html

class Generics {
  def getTweet : (Bird => String) = (a: Animal) => a.sound
}

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

//covariance
class Covarient[+A]

//contravariant
class Animal{ val sound = "rustle" }
class Bird extends Animal { override val sound = "cluck" }



trait Function1 [-T1, +R] extends AnyRef


/******* Bounds *******/





