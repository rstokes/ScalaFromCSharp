package net.robstokes.demo.oldtricks

//light weight syntax for tuples

class Tuples {
  val a = (1, "3", List(3, 4))
  val b : (Int, String, List[Int]) = (1, "3", List(3, 4))
  val c : (Int, String, List[Int]) = new Tuple3(1, "3", List(3, 4))
  val d : Tuple3[Int, String, List[Int]] = new Tuple3[Int, String, List[Int]](1, "3", List(3, 4)) //C#

  def fun() : String = {
    val (a, b, c) = createTuple()
    b
  }

  def createTuple() : (Int, String, List[Int]) = {
    (1, "3", List(3,4))  //return is optional in most cases
  }
}