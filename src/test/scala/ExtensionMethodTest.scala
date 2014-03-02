import collection.mutable.Stack
import org.scalatest._
import net.robstokes.demo.oldtricks.ExtensionMethods._

class ExtensionMethodTest extends FlatSpec with Matchers{
  "select" should "apply a function to all values" in {
    val items = List(1,2)
    items.select(_+2) should be (List(3,4))
  }

  "single" should "return the only element of a sequence" in {
    val itemInCollection = List(1)
    itemInCollection.single() should be (1)
  }

  "single" should "blow chunks if there are more than one element in the sequence" in {
    val twoItems = List(1,2)
    evaluating{
      twoItems.single()
    } should produce [IllegalArgumentException]
  }

  "single" should "blow chunks if there are no elements in the sequence" in {
    val twoItems = List()
    evaluating{
      twoItems.single()
    } should produce [IllegalArgumentException]
  }

  "join" should "return the union of two collections" in {
    val collectionOne = List(1,2,3,4,5)
    val collectionTwo = List(4,5,6,7,8)
    collectionOne.join(collectionTwo)(a => a, b => b, (c, d) => c) should be (List(4, 5))
    collectionOne.join(collectionTwo)(a => a, b => b, (c, d) => c + d) should be (List(8, 10))
  }

  "join" should "return an empty collection if there is no union" in {
    val collectionOne = List(1,2,3,4,5)
    val collectionTwo = List(6,7,8,9,10)
    collectionOne.join(collectionTwo)(a => a, b => b, (c, d) => c) should be (List())
  }

  "groupJoin" should "join and create a grouping" in {
    case class Pet(name: String, owner: Person)
    case class Person(name: String)
    case class PersonPet(owner: Person, pets: Traversable[Pet])

    val terry = Person("Terry")
    val jerry = Person("Jerry")

    val people = List(jerry, terry)
    val pets = List(Pet("Sparky", terry),  Pet("Sparky", terry), Pet("Spike", jerry))

    people.groupJoin(pets)(_.name, _.owner.name, (person, pets) => PersonPet(person, pets)) should be
      List(PersonPet(terry, List(Pet("Sparky", terry), Pet("Sparky", terry))), PersonPet(jerry, List(Pet("Spike", jerry))))
  }
}
