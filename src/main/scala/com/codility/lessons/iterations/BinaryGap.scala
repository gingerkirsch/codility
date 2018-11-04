package com.codility.lessons.iterations

object BinaryGap {

  // 100% score
  def solution(n: Int): Int = {
    def toBinaryString(n: Int): String = {
      var binaryString = ""
      var dec = n
      while (dec > 0){
        val digit = dec % 2
        binaryString = digit.toString + binaryString
        dec = dec / 2
      }
      binaryString
    }

    def findLongestBinaryGap(binaryString: String): Int = {
      binaryString.replaceAll("0+$", "").replaceAll("^0","").split("1+")
          .map(_.length).foldLeft(0)((a,b) => Math.max(a,b))
    }

    findLongestBinaryGap(toBinaryString(n))
  }

}
