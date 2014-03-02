package net.robstokes.demo.oldtricks

class Generics {
  class SuperStack[T] {
    var elems: List[T] = Nil
    def push(x: T) { elems = x :: elems }
    def top: T = elems.head
    def pop() { elems = elems.tail }
  }







}
