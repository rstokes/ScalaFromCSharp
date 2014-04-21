package net.robstokes.demo.oldtricks

//http://tomjefferys.blogspot.com/2011/11/operator-overloading-in-scala.html

//scala doesn't support operator overloading because scala doesn't have operators.
//Instead Scala has lightweight flexible syntax for functions
//Only unary operators +, -, !, and ~ are special
case class OperatorOverloading(val a: Int, val b: Int) {
  def +(that: OperatorOverloading) = {
    OperatorOverloading(this.a + that.a, this.b + that.b)
  }

  def minus(that: OperatorOverloading) = {
    OperatorOverloading(this.a - that.a, this.b - that.b)
  }

  def unary_! : Boolean = a > 0 && b > 0
}

object Fun{
  def example(){
    val a = OperatorOverloading(1, 2)
    val b = OperatorOverloading(2, 3)

    val c = a + b
    val d = a.+(b)

    val e = !a
  }
}
