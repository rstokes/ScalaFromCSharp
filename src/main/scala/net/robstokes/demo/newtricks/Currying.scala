package net.robstokes.demo.newtricks


class Currying {

  def adder(x: Int)(y: Int) : Int = {
    x + y

    val doubleAdder =  getDoubleAdder();
    doubleAdder(3) // 5

  }

  def getDoubleAdder: (Int) => Int = {
    adder(2)_
  }

}
