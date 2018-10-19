package com.codility.challenges.calcium


trait SpeedCameras {

  /**
    * Given arrays A and B of N integers and integer K, returns the minimum length of
    * the longest path unmonitored by speed cameras after placing at most K speed cam */
  def solution(a: Array[Int], b: Array[Int], k: Int): Int = {
    val edges: Array[(Int, Int)] = a zip b
    println("edges: " + edges)
    val vertices: Set[Int] = ((a ++ b) toSet)
    println("vertices: " + vertices)
    val paths: Set[(Int, Array[Int])] = vertices map { vertex =>
      val incidentEdges: Array[(Int, Int)] = edges filter { e => e._1 == vertex || e._2 == vertex }
      val adjacentVertices = incidentEdges map { e => if (e._1 == vertex) e._2 else e._1 }
      (vertex, adjacentVertices)
    }
    println("paths: " + paths)

    def longestPath(path: (Int, Array[Int])): Int = {
      def walk(path: (Int, Array[Int]), visited: Array[Int]): Int = {
        path._2.size match {
          case 0 =>
            visited.length
          case _ => {
            val nextHops = path._2 filterNot (visited contains _) // array.empty
            nextHops.length match {
              case 0 => visited.length
              case _ =>
                paths filter (p => nextHops.contains(p._1)) map { hop => walk(hop, visited.:+(path._1)) } max
            }
          }
        }
      }

      walk(path, Array.emptyIntArray)
    }

    /*def longestUnmonitored(paths: Set[(Int, Array[Int])], k: Int) = {
      val cutted: Array[(Int, Int)] = Array.empty
      // k - depth of recursion
      //for (i <- 1 until k) {
      chooseTheBestCut(paths, cutted, k)
      //}

      def chooseTheBestCut(paths: Set[(Int, Array[Int])], cutted: Array[(Int, Int)], k: Int): Int = {
        k match {
          case O =>
            c
          case _ =>
            // inside the graph
            paths map (longestPath(_)) max
        }
      }*/
    longestPath(paths.head)
  }


  /*

      verticesWithAdj: Set[(Int - vertex, Array[Int] - adjacents)]    // 1 (5, 0, 1)   + longestPath
      foreach (vertex & adjacents in verticesWithAdj) longestPath

      foreach (edge in edges)
        cut : verticesWithAdj.get(edge._1) remove edge._2
              verticeWithAdj.get(edge._2) remove edge._1
        foreach (vertex & adjacents in verticesWithAdj) longestPath*/

}

object Solution extends SpeedCameras with App {
  val a = Array(5, 1, 0, 2, 7, 0, 6, 6, 1)
  val b = Array(1, 0, 7, 4, 2, 6, 8, 3, 9)
  val k = 2

  val response = solution(a, b, k)
  println("The longest path: " + response)
}
