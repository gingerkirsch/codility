package com.codility.lessons.sieveOfErathosthenes

object CountNonDivisible {

  // 66% score  O(N ** 2)
  def solution(a: Array[Int]): Array[Int] = {
    val result = Array.ofDim[Int](a.length)
    for (i <- 0 until a.length){
      for (j <- 0 until a.length){
        if (i != j && a(i) % a(j) != 0){
          result(i) = result(i) + 1
        }
      }
    }
    result
  }
}
