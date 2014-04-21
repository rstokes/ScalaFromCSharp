//syllabus
import net.robstokes.demo.oldtricks.LinqAnalogies
import net.robstokes.demo.oldtricks.ExtensionMethods
import net.robstokes.demo.oldtricks.Generics
import net.robstokes.demo.oldtricks.Tuples
import net.robstokes.demo.oldtricks.CommonInterfaces
//unit tests

//references
//http://stackoverflow.com/questions/1755345/scala-difference-between-object-and-class



object Main { // object is shorthand for a singleton,
  def main(args: Array[String]){  // no equals is shorthand for : Unit. This is similar to void
    println("hello world")
    val instance = new MyClass(1)
    instance.basics()
  }
}

class MyClass(val a: Int){

  def basics() : Int = { //optional return type
    val a = 1; // semicolons are optional
    val b : Int = 2  // val declares an immutable reference
    var c : Int = 3  // var declare a mutable reference

    val peopleAges : scala.collection.mutable.Map[String, Int] = scala.collection.mutable.Map()
    // all collections in the scala std library have a mutable and immutable type of the same name except list for more http://docs.scala-lang.org/overviews/collections/concrete-mutable-collection-classes.html
    peopleAges.put("Rob", 26)
    peopleAges("Lily") = 25
    peopleAges += "John" -> 30

    println(peopleAges) // no System.out.println or import due to scala predef. For more http://www.scala-lang.org/api/2.10.3/index.html#scala.Predef
    //toString on collections prints something useful
    a
  }

}

