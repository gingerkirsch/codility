package com.codility.lessons.timeComplexity

object PermMissingElem {

  // 80% score
  def solution(a: Array[Int]): Int = {
    var sum: Long = (a.length + 1) * (a.length + 2) / 2
    for (i <- 0 until a.length){
      sum = sum - a(i)
    }
    sum.toInt
  }
}
