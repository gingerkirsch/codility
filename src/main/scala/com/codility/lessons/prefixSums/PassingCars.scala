package com.codility.lessons.prefixSums

object PassingCars {
  def solution(a: Array[Int]): Int = {
    var goingEast = 0;
    var result = 0;
    for (i <- 0 until a.length) {
      if (a(i) == 0) goingEast = goingEast + 1
      if (a(i) == 1) result = result + goingEast
      if (result > 1000000000) return -1
    }
    result
  }
}
