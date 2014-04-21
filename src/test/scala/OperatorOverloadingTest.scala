import net.robstokes.demo.oldtricks.OperatorOverloading
import org.scalatest.{Matchers, FlatSpec}

class OperatorOverloadingTest  extends FlatSpec with Matchers{

  "The plus operator" should "sum 2 values" in{
    val a = OperatorOverloading(1, 2)
    val b = OperatorOverloading(3, 4)

    a + b should be (OperatorOverloading(4, 6))
  }

  "The minus operator" should "subtract 2 values" in{
    val a = OperatorOverloading(1, 2)
    val b = OperatorOverloading(3, 4)

    a minus b should be (OperatorOverloading(-2, -2))
  }

  "Unary !" should "be false when one value is negative" in{
    !OperatorOverloading(-1, -1) should be (false)
    !OperatorOverloading(-1, 1) should be (false)
    !OperatorOverloading(1,-1) should be (false)
    !OperatorOverloading(1, 1) should be (true)
  }
}
