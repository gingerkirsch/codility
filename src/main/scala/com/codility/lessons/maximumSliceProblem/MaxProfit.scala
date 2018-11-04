package com.codility.lessons.maximumSliceProblem

object Solution {

  // 100% score
  def solution(a: Array[Int]): Int = {
    fastSolution(a)
  }

  def slowSolution(a: Array[Int]): Int = {
    var max = 0;
    for (p <- 0 until a.length){
      for (q <- (p+1) until a.length){
        val profit = a(q) - a(p)
        if (profit > max){
          max = profit
        }
      }
    }
    max
  }

  def fastSolution(a: Array[Int]): Int = {
    def max(a: Int, b: Int): Int = if (a > b) a else b
    var max_ending = 0
    var max_slice = 0
    for (i <- 0 until (a.length -1)) {
      max_ending = max(0, max_ending + a(i + 1) - a(i))
      max_slice = max(max_slice, max_ending)
    }
    max_slice
  }

}
