import net.robstokes.demo.oldtricks.Tuples
import org.scalatest._

class TupleTest extends FlatSpec with Matchers{
  it should "return the string 3" in{
    val tuple = new Tuples();
    tuple.fun() should be ("3")
  }

}
