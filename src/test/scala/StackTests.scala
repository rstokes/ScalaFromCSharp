import collection.mutable.Stack
import org.scalatest._
import net.robstokes.demo.oldtricks._

class StackTests  extends FlatSpec with Matchers{
  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new InvariantStack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new InvariantStack[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }
  }
}
