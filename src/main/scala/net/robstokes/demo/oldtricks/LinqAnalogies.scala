package net.robstokes.demo.oldtricks

import net.robstokes.demo.oldtricks.ExtensionMethods.TraversableExtensions

//see: http://stackoverflow.com/questions/8104846/chart-of-ienumerable-linq-equivalents-in-scala

class LinqAnalogies {
  val xs : List[Int] = List(1, 2, 3, 4, 5, 6, 7)
  val ys = List(6, 7)
  val xxs = List(List(2,3,4), List(4,5,6))

  def examples() : Unit = {
    xs.map(f => f.toString)                           //xs.Select(i => i.ToString())
    xxs.flatMap(f => f.toString())                     //xxs.SelectMany(i => i.ToString())
    xs.filter(f => f > 3)                             //xs.Where(f => f > 3)

    xs.reduceLeft((a, b) => a + b)                    //xs.Aggregate((a, b) => a + b)
    xs.foldLeft(1)((a, b) => a + b)                   //xs.Aggregate(1, (a, b) => a + b)

    xs.forall(a => if(a%2 == 0) true else false)      //xs.forall(a => a%2 == 0 ? true : false)
    xs.nonEmpty                                       //xs.Any()
    xs.exists(a => a > 1)                             //xs.Any(a => a > 1)

    xs.map(_.asInstanceOf[Double])                    //xs.Cast<Double>()
    xs.collect { case x: Int => x }                   //xs.OfType<int>()

    xs ++ ys                                          //xs.Concat(ys)

    xs.distinct                                       //xs.Distinct()
    xs.contains(ys)                                   //xs.Contains(x)
    xs.exists _                                       //xs.Contains(x, eq)
    xs.diff(ys)                                       //xs.Except(ys)
    xs.intersect(ys)                                  //xs.Intersect(ys)
    xs.union(ys)                                      //xs.Union(ys)

    xs.head                                           //xs.First()
    xs.last                                           //xs.Last()
    xs.find(_ > 2)                                    //xs.First(a => a > 3)
    xs.size                                           //xs.Count()
    xs.count(_ > 3)                                   //xs.count(a => a > 3)

    xs.groupBy(a => if(a%2 == 0) true else false)     //xs.GroupBy(a => a.Modulo(2) == 0 ? true : false)

    xs.max                                            //xs.Max()
    xs.maxBy(_ * 2)                                   //xs.Max(a => a * 2)
    xs.min                                            //xs.Min()
    xs.minBy(_ * 2)                                   //xs.Min(a => a * 2)

    xs.sortBy(f => f)                                 //xs.OrderBy(f)
    xs.sortBy(f => f)(Ordering[Int])                  //xs.OrderBy(f, comp)
    xs.sortBy(- _)                                    //xs.OrderByDescending(f)
    xs.sortBy(- _)(Ordering[Int].reverse)             //xs.OrderByDescending(f, comp)

    (xs, ys).zipped.map((x,y) => x + y )              //xs.Zip(ys, (x,y) => x + y)

    xs.select(x => x + 2)                             //magic

  }

}
