package net.robstokes.demo.newtricks

// implements getHashcode and equals for you

trait Person{
  val id: Int
  val name: String
}

case class Company(name: String)
case class Employee(id: Int, name: String, company: Company) extends Person
case class Vendor(id: Int, name:String, company: Company) extends Person
