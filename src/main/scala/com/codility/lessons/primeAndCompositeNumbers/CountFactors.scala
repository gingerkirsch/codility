package com.codility.lessons.primeAndCompositeNumbers

object CountFactors {

  // O(sqrt(N)) 92% score
  def solution(n: Int): Int = n match {
    case 0 => 0
    case 1 => 1
    case _ => {
      var factors = 2
      var i = 2
      while (i * i < n){
        if (n % i == 0){
          factors = factors + 2
        }
        i = i + 1
      }
      if (i * i == n){
        factors = factors + 1
      }
      factors
    }
  }
}
