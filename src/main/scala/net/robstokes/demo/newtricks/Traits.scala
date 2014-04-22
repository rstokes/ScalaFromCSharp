package net.robstokes.demo.newtricks

//http://stackoverflow.com/questions/1991042/scala-traits-vs-abstract-classes

//traits are collections of fields and behaviors that you can extend or mixin
// to your classes.
/*Why not just use an abstract class?
Abstract classes can have constructor parameters as well as type parameters.
  Traits can have only type parameters.
Abstract classes are fully interoperable with Java. You can call them from Java code without any wrappers.
  Traits are fully interoperable only if they do not contain any implementation code
Traits can be mixed
Classes can extend many traits
Rule of thumb.  Use a trait unless you need an abstract class
*/
class Traits {

}

trait Car {
  val brand: String
}

trait Shiny {
  val shineRefraction: Int

  def isWaxed() : Boolean = {
    if(shineRefraction > 0)
      true
    false
  }
}

class BMW extends Car with Shiny {
  val brand = "BMW"
  val shineRefraction = 12
  val thisShouldBeImmutable = 20
}