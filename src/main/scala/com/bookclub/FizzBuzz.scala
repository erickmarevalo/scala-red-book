package com.bookclub

import scala.annotation.tailrec

// S/O Erick
object FizzBuzzModule {

  private def isDivisible(x: Int, y: Int): Boolean = x % y == 0

  private def getString(int: Int): String = {
    if (isDivisible(int, 3) && isDivisible(int, 5)) "FizzBuzz"
    else if (isDivisible(int, 5)) "Fizz"
    else if (isDivisible(int, 3)) "Buzz"
    else int.toString
  }

  def main(args: Array[String]): Unit = {
    val range = Range.inclusive(1, 100)
    val strings = range.map(getString)
    strings.foreach(println)
  }
}

// S/O Caleb
object FizzBuzzThree extends App {
  def isFizz(x: Int): Boolean = {
    (x % 3) == 0
  }

  def isBuzz(x: Int): Boolean = {
    (x % 5) == 0
  }

  def isFizzBuzz(x: Int): Boolean = {
    isFizz(x) && isBuzz(x)
  }

  def getFizzBuzz(x: Int): String = {
    if (isFizzBuzz(x))
      "FizzBuzz"
    else if (isFizz(x))
      "Fizz"
    else if (isBuzz(x))
      "Buzz"
    else
      x.toString()
  }

  (1 to 15).map(x => getFizzBuzz(x))
    .map(x => println(x))
}

// S/O Cassidy
case class FizzBuzz() {
  def generateList(upperBound: Int, currentList: Array[String] = Array()): Array[String] = {
    if (currentList.length < upperBound) {
      this.generateList(
        upperBound,
        currentList :+ this.fizzbuzzification(currentList.length + 1)
      )
    } else {
      currentList
    }
  }

  private def fizzbuzzification(num: Int): String ={
    num match {
      case x if x % 3 == 0 && x % 5 == 0 => "FizzBuzz"
      case x if x % 3 == 0 => "Fizz"
      case x if x % 5 == 0 => "Buzz"
      case _ => num.toString
    }
  }
}

object TestFizzBuzzTwo extends App {
  val result = FizzBuzz().generateList(100)
  println(result.mkString("\n"))
}

// S/O Pavel
class FizBuzz {
  def main(): Unit = {
    println(this.fizzBuzz())
  }

  def fizzBuzz(): Unit = {
    @annotation.tailrec
    def go(n: Int): Unit = {
      if (isDivisibleBy(n, 3) && !isDivisibleBy(n, 5)) {
        printItem("Fizz")
      } else if (isDivisibleBy(n, 5) && !isDivisibleBy(n, 3)) {
        printItem("Buzz")
      } else if (isDivisibleBy(n, 5) && isDivisibleBy(n, 3)){
        printItem("FizzBuzz")
      } else {
        printItem(n.toString)
      }

      if (n < 100) go(n + 1)
    }

    def isDivisibleBy(n: Int, d: Int): Boolean = {
      n % d == 0
    }

    def printItem(s: String): Unit = {
      println(s)
    }

    go(0)
  }
}

object TestFizzBuzz extends App {
  val fizzz = new FizBuzz

  fizzz.fizzBuzz()
}

// S/O James
object FizzBuzz {
  def main(args: Array[String]): Unit = {
    fizzBuzz(1, 100)
  }

  @tailrec
  private def fizzBuzz(currentNum: Int, inclusiveStop: Int): Unit = {
    if (currentNum > inclusiveStop) return

    def isDivisibleBy(x1: Int, x2: Int) = x1 % x2 == 0

    val value = currentNum match {
      case x if isDivisibleBy(x, 3) && isDivisibleBy(x, 5) => "FizzBuzz"
      case x if isDivisibleBy(x, 5) => "Buzz"
      case x if isDivisibleBy(x, 3) => "Fizz"
      case x => x.toString
    }

    println(value)
    fizzBuzz(currentNum + 1, inclusiveStop)
  }
}



















// start of my unimpressive solutions

object FizzBuzzOOP extends App {
  for (i <- 1 to 100) {
    if (i % 15 == 0)
      println("FizzBuzz")
    else if (i % 3 == 0)
      println("Fizz")
    else if (i % 5 == 0)
      println("Buzz")
    else
      println(i)
  }
}

object FizzBuzzFunc extends App {
  def fizzBuzz(x: Int): String = {
    if (x % 15 == 0)
      "FizzBuzz"
    else if (x % 3 == 0)
      "Fizz"
    else if (x % 5 == 0)
      "Buzz"
    else
      x.toString
  }

  (1 to 100).foreach(fizzBuzz _ andThen println) // println(fizzbuzz(i))
}

object FizzBuzzGalaxyBrain extends App {
  (1 to 100).map(i => (i % 3, i % 5) match {
    case (0, 0) => "FizzBuzz"
    case (0, _) => "Fizz"
    case (_, 0) => "Buzz"
    case _ => i
  }).foreach(println)
}
