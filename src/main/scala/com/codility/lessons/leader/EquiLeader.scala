package com.codility.lessons.leader

import scala.collection.mutable.Stack

object EquiLeader {
  def solution(a: Array[Int]): Int = {
    // O (n**2) 55% score
    def leader(a: Array[Int]): Int = a.length match {
      case 0 => -1
      case 1 => a(0)
      case _ => {
        val stack = Stack[Int]()
        for (i <- 0 until a.length){
          if (stack.isEmpty){
            stack.push(a(i))
          } else if (stack.top != a(i)) {
            stack.pop
          } else {
            stack.push(a(i))
          }
        }
        var candidate = -1
        var leader = -1
        var count = 0
        if (stack.size > 0) {
          candidate = stack.top
        }
        for (i <- 0 until a.length){
          if (a(i) == candidate){
            count = count + 1
          }
          if (count > (a.length / 2)){
            leader = candidate
          }
        }
        leader
      }
    }

    var equiLeaders = 0
    for (i <- 0 until a.length){
      val section = a.splitAt(i)
      val leaderLeft = leader(section._1)
      val leaderRight = leader(section._2)
      if (leaderLeft != -1 && leaderLeft == leaderRight){
        equiLeaders = equiLeaders + 1
      }
    }
    equiLeaders
  }
}
