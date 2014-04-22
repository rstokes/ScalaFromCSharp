//syllabus
//main
import net.robstokes.demo.oldtricks.Tuples
import net.robstokes.demo.oldtricks.LinqAnalogies
import net.robstokes.demo.oldtricks.ExtensionMethods
import net.robstokes.demo.oldtricks.Generics
import net.robstokes.demo.oldtricks.CommonInterfaces
//worksheet
//repl

import net.robstokes.demo.newtricks.Traits
//import net.robstokes.demo.newtricks.CaseClasses
import net.robstokes.demo.newtricks.PatternMatching

//references
//http://stackoverflow.com/questions/1755345/scala-difference-between-object-and-class
//http://twitter.github.io/scala_school


/* Why Scala?
Expressive
  -First-class functions
  -Closures
Concise
  -Type inference
  -Literal syntax for function creation
Java interoperability
  -Can reuse java libraries
  -Can reuse java tools
  -No performance penalty
 */

/* How Scala?
Compiles to java bytecode
Works with any standard JVM
  -Or even some non-standard JVMs like Dalvik
  -Scala compiler written by author of Java compiler
 */


object Main { // object is shorthand for a singleton, often used as factories
  def main(args: Array[String]){  // no equals is shorthand for : Unit. This is similar to void
    println("hello world")
    val instance = new MyClass(1)
    instance.basics()
  }
}

//no constructor overloading
class MyClass(val a: Int){

  val b : Int = {
    //some stuff to evaluate at construction
    10
  }

  def basics() = { //optional return type in most cases
    val a = 1; // semicolons are optional
    val b : Int = 2  // val declares an immutable reference
    var c : Int = 3  // var declares a mutable reference

    val peopleAges : scala.collection.mutable.Map[String, Int] = scala.collection.mutable.Map()
    // all collections in the scala std library have a mutable and immutable type of the same name except list for
    //    more http://docs.scala-lang.org/overviews/collections/concrete-mutable-collection-classes.html
    peopleAges.put("Rob", 26)
    peopleAges("Jake") = 25
    peopleAges += "John" -> 30

    println(peopleAges) // no System.out.println or import due to scala predef. For more http://www.scala-lang.org/api/2.10.3/index.html#scala.Predef
    //toString on collections prints something useful
    a
  }

}

