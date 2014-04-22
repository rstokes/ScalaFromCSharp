package net.robstokes.demo.oldtricks

//references
//http://www.scala-lang.org/api/2.10.4/index.html#scala.math.Ordering


class CommonInterfaces {


}

//IComparable ~ Ordered
case class MyComparable(val a: Int) extends Ordered[MyComparable]{
  override def compare(that: MyComparable): Int = {
    this.a - that.a
  }
}

//IComparer ~ Ordering
case class Person(name: String, age: Int)
object MyComparer extends Ordering[Person]{
  override def compare(x: Person, y: Person): Int = {
    x.age compare y.age
  }
}

//Observable
//Observer
//blocking queues