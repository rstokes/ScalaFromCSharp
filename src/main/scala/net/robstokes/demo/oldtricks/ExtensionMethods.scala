package net.robstokes.demo.oldtricks

// Pimp My Library Pattern
// reference: http://alvinalexander.com/scala/scala-2.10-implicit-class-example
// http://docs.scala-lang.org/overviews/core/implicit-classes.html
// http://stackoverflow.com/questions/1052476/what-is-scalas-yield

object ExtensionMethods {
  implicit class TraversableExtensions[A](val collection : Traversable[A]){ //makes the class’ primary constructor available for implicit conversions
                                                                            // when the class is in scope.  They must be inside a class, trait or object
                                                                            // and may only take one implicit argument in it's constructor.  Introduced in 2.10
    def select[B](func: A => B) : Traversable[B] = {
      for(a <- collection) yield func(a)
      //compiles to
      //collection.map(a => func(a))
    }

    //not in the std lib
    def single[T](): A = {
      if(collection.isEmpty) throw new IllegalArgumentException("Empty sequence!")
      if (collection.size > 1) throw new IllegalArgumentException("More than one element!")
      collection.head
    }

    def join[B, K, R](inner: Traversable[B])(outKey: A => K, inKey: B => K, f: (A, B) => R): Traversable[R] = {
      for(o <- collection; i <- inner; if outKey(o) == inKey(i)) yield f(o, i)
    }

    def groupJoin[B, K, R](inner: Traversable[B])(outKey: A => K, inKey: B => K, f: (A, Traversable[B]) => R): Traversable[R] = {
      for(o <- collection) yield {
        val zs = for(i <- inner; if outKey(o) == inKey(i)) yield i
        f(o, zs)
      }
    }
  }
}