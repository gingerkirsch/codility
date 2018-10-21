package com.codility.lessons.timeComplexity

object FrogJmp {
  def solution(x: Int, y: Int, d: Int): Int = {
    val distance = y - x
    val suggestedJumps = distance / d
    if (distance % d > 0) {
      suggestedJumps + 1
    } else {
      suggestedJumps
    }
  }
}
