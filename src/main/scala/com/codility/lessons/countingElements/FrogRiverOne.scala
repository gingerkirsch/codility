package com.codility.lessons.countingElements

object FrogRiverOne {
  def solution(x: Int, a: Array[Int]): Int = {
    val useful = a.distinct
    if (useful.length < x) -1
    else a.indexOf(useful(useful.length-1))
  }
}
