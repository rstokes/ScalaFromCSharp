package net.robstokes.demo.oldtricks

class CommonInterfaces {


}

//IComparable ~ Ordered
class MyComparable(val a: Int) extends Ordered[MyComparable]{
  override def compare(that: MyComparable): Int = {
    this.a - that.a;
  }
}
