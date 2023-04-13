package com.bookclub

object Chapter2 {

  private def fib(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc1: Int, acc2: Int): Int = {
      if (n <= 1) acc1
      else go(n-1, acc2, acc1 + acc2)
    }

    go(n, 0, 1)
  }

  private def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @annotation.tailrec
    def go(e: A, as: Array[A]): Boolean = {
      if (as.isEmpty) true
      else if (ordered(e, as.head)) go(as.head, as.tail)
      else false
    }

    go(as.head, as.tail)
  }

  private def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    a => b => f(a, b)

  private def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a, b) => f(a)(b)

  private def compose[A, B, C](f: B => C, g: A => B): A => C =
    a => f(g(a))

  def main(args: Array[String]): Unit = {
    println(fib(6))
    print(isSorted(Array(5, 4, 3, 2, 1), (a: Int, b: Int) => a > b))
  }

}
