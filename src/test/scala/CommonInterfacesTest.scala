import net.robstokes.demo.oldtricks.MyComparable
import org.scalatest.{Matchers, FlatSpec}

class CommonInterfacesTest extends FlatSpec with Matchers{
  "comparing a and b" should "yield 0" in{
    val a = new MyComparable(1);
    val b = new MyComparable(1);

    a.compare(b) should be (0)
  }

  "comparing a and b" should "yield greater than 0" in{
    val a = new MyComparable(2);
    val b = new MyComparable(1);

    a.compare(b) should be > 0
  }

  "comparing a and b" should "yield less than 0" in{
    val a = new MyComparable(1);
    val b = new MyComparable(2);

    a.compare(b) should be < 0
  }
}
