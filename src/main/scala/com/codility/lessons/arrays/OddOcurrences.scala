package com.codility.lessons.arrays

object OddOcurrences {

  // 100% score
  def solution(a: Array[Int], k: Int): Int = {
    a.reduce(_ ^ _)
  }
}
