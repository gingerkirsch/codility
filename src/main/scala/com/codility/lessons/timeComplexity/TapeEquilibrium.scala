package com.codility.lessons.timeComplexity

object TapeEquilibrium {

  // 91% score
  def solution(a: Array[Int]): Int = a.length match {
    case 2 if a(0) > a(1) => a(0)
    case 2 if a(1) > a(0) => a(1)
    case _ => {
      val n = a.length
      val sum = a.sum
      var left = a(0)
      var right = sum - a(0)
      var min = Math.abs(left - right)
      for (i <- 2 until n){
        left = left + a(i - 1)
        right = right - a(i - 1)
        val current = Math.abs(left - right)
        if (current < min) {
          min = current
        }
      }
      min
    }
  }
}
