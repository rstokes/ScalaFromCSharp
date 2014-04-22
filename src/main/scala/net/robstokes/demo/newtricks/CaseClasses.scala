package net.robstokes.demo.newtricks

//http://www.artima.com/pins1ed/case-classes-and-pattern-matching.html

// compiler adds a factory method to omit new keyword for syntactic conveniences
// The second syntactic convenience is that all arguments in the parameter list of
//    a case class implicitly get a val prefix, so they are maintained as fields
//Third, the compiler adds "natural" implementations of methods toString, hashCode,
//    and equals to your class. They will print, hash, and compare a whole tree
//    consisting of the class and (recursively) all its arguments. Since == in Scala
//    always forwards to equals, this means in particular that elements of case classes
//    are always compared structurally
trait Person{
  val id: Int
  val name: String
  val comapny = List(Company("HCA"), Company("HPG"))
  def sayMyName() = {
    println(name)
  }
}

case class Company(name: String)
case class Employee(id: Int, name: String, company: Company) extends Person
case class Vendor(id: Int, name:String, company: Company)