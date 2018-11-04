package com.codility.lessons.euclideanAlgorithm

object ChocolatesByNumbers {

  // 62% score  O (n + m)
  def solution(n: Int, m: Int): Int = {
    // write your code in Scala 2.12
    val chocolates = Array.ofDim[Boolean](n)
    chocolates(0) = true
    var eaten = 1
    var i = 0
    while (chocolates((i + m) % n) == false){
      chocolates(i) = true
      i = (i + m) % n
      eaten = eaten + 1
    }
    eaten
  }
}