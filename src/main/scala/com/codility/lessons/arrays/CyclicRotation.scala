package com.codility.lessons.arrays

object CyclicRotation {
  def solution(a: Array[Int], k: Int): Array[Int] = {
    def rotate(l: List[Int], k: Int): List[Int] = {
      val result = List(l.last) ::: l.take(l.length-1)
      if (k == 1) result
      else rotate(result, k-1)
    }

    (a.length, k) match {
      case (n, _) if (n < 2) => a
      case (n, m) if (n == m) => a
      case (_, m) if (m == 0) => a
      case (n, m) => rotate(a.toList, k).toArray

    }
  }
}
