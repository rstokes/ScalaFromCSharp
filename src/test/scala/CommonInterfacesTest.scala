import net.robstokes.demo.oldtricks.{MyComparer, Person, MyComparable}
import org.scalatest.{Matchers, FlatSpec}
import scala.util.Sorting

//references
//http://www.scala-lang.org/api/2.10.4/index.html#scala.math.Ordering

class CommonInterfacesTest extends FlatSpec with Matchers{
  "comparing a and b" should "yield 0" in{
    val a = MyComparable(1)
    val b = MyComparable(1)

    a.compare(b) should be (0)
  }

  "comparing a and b" should "yield greater than 0" in{
    val a = MyComparable(2)
    val b = MyComparable(1)

    a.compare(b) should be > 0
  }

  "comparing a and b" should "yield less than 0" in{
    val a = MyComparable(1)
    val b = MyComparable(2)

    a.compare(b) should be < 0
  }

  "sorting with Ordering" should "order the list based on age" in{
    val people = Array(Person("bob", 30), Person("ann", 32), Person("carl", 19))

    Sorting.quickSort(people)(MyComparer)

    people should be (Array(Person("carl", 19), Person("bob", 30), Person("ann", 32)))
  }

  "sorting with Ordered" should "order the list based on the difference of a" in {
    val comparables =  Array(MyComparable(3), MyComparable(4), MyComparable(2))

    Sorting.quickSort(comparables)

    comparables should be (Array(MyComparable(2), MyComparable(3), MyComparable(4)))

  }



}
