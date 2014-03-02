package net.robstokes.demo.oldtricks

// Pimp My Library Pattern
// reference: http://alvinalexander.com/scala/scala-2.10-implicit-class-example

object ExtensionMethods {
  implicit class TraversableExtensions[A](val collection : Traversable[A]){

    def select[B](func: A => B) : Traversable[B] = {
      for(a <- collection) yield func(a)
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