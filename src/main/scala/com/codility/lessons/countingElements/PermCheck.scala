package com.codility.lessons.countingElements

object PermCheck {
  def solution(a: Array[Int]): Int = {
    val n = a.length
    val sumOfPermutation = (n * (n + 1)) / 2
    if (a.distinct.length < n) {
      0
    } else if (a.sum != sumOfPermutation){
      0
    } else {
      1
    }
  }
}
