package com.codility.lessons.arrays

object OddOcurrences {
  def solution(a: Array[Int], k: Int): Int = {
    a.reduce(_ ^ _)
  }
}
