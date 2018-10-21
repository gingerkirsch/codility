package com.codility.lessons.stacksAndQueues

object Brackets {
  def solution(s: String): Int = {
    val arr = s.toCharArray
    val stack = Array.ofDim[Char](s.length)
    var stackPointer: Int = 0

    def push(ch: Char): Unit = {
      stack(stackPointer) = ch
      stackPointer = stackPointer + 1
    }

    def pop(): Char = {
      stackPointer = stackPointer - 1
      stack(stackPointer)
    }

    if (arr.length == 0) {
      1
    } else if (arr.length % 2 == 1) {
      0
    } else {
      for (i <- 0 until s.length) {
        print(arr(i))
        if (arr(i) == '{' || arr(i) == '(' || arr(i) == '[') {
          println("pushed " + arr(i))
          push(s(i))
        } else {
          val nest = pop() + "" + arr(i)
          println("nest " + nest)
          if (nest != "()" && nest != "{}" && nest != "[]") {
            println("not a nest")
            return 0
          }
        }
      }
      if (stackPointer > 0) {
        0
      } else {
        1
      }
    }
  }
}
