package net.robstokes.demo.newtricks

//http://twitter.github.io/scala_school/basics2.html
//one of the more useful features of scala
class PatternMatching {
  //matching on values
  val times = 1
  val str = "x"

  times match { // looks a lot like a switch case
    case 1 => "one"
    case 2 => "two"
    case _ => "some other number" //~default
  }

  //matching with guards
  times match {
    case i if i == 1 => "one"
    case i if i == 2 => "two"
    case _ => "some other number"
  }

  //matching on type
  def bigger(o: Any): Any = {
    o match {
      case i: Int if i < 0 => i - 1
      case i: Int => i + 1
      case d: Double if d < 0.0 => d - 0.1
      case d: Double => d + 0.1
      case text: String => text + "s"
    }
  }


  case class Calculator(brand: String, model: String)
  //matching on class members
  def calcType(calc: Calculator) = calc match {
    case _ if calc.brand == "hp" && calc.model == "20B" => "financial"
    case _ if calc.brand == "hp" && calc.model == "48G" => "scientific"
    case _ if calc.brand == "hp" && calc.model == "30B" => "business"
    case _ => "unknown"
  }

  //case classes with pattern matching
  val hp20b = Calculator("hp", "20B")
  val hp30b = Calculator("hp", "30B")

  def calcTypes(calc: Calculator) = calc match {
    case Calculator("hp", "20B") => "financial"
    case Calculator("hp", "48G") => "scientific"
    case Calculator("hp", "30B") => "business"
    case Calculator(ourBrand, ourModel) => "Calculator: %s %s is of unknown type".format(ourBrand, ourModel)
  }

  //pattern matching with exceptions
  val remoteCalculatorService = new RemoteCalculatorService

  try {
    remoteCalculatorService.add(1, 2)
  } catch {
    case e: ServerIsDownException => println("the remote calculator service is unavailable. should have kept your trusty HP.")
    case ReallyBadException(_, "Something bad has happened") => println("oh no!")
    case ReallyBadException(_, "Something really bad has happened") => println("oh dear!")
  } finally {
    remoteCalculatorService.close()
  }

}


class ServerIsDownException extends Exception
case class ReallyBadException(e: Exception, msg: String) extends Exception
class RemoteCalculatorService{
  def add(a: Int, b: Int) = a + b
  def close() = Nil
}

