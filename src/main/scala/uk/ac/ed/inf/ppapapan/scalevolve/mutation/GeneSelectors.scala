/*
 *  Copyright © 2020, Petros Papapanagiotou, all rights reserved.
 *  School of Informatics, The University of Edinburgh
 */

package uk.ac.ed.inf.ppapapan.scalevolve.mutation

import uk.ac.ed.inf.ppapapan.scalevolve.Individual
import scala.util.Random
import scala.collection.mutable.ArraySeq

trait GeneSelector[A] {
  def select[A](a: Individual[A]): Int = select(1,a).head
  def select[A](n: Int, a: Individual[A]): Seq[Int]
}

case class RandomGeneSelector[A](random: Random = Random) extends GeneSelector[A] {
  override def select[A](n: Int, a: Individual[A]): Seq[Int] = {
    random.shuffle(0 to a.length toList).take(n)
  }
}

trait NeighbourSelector[A] {
  def select(a: Individual[A]): (Int, Int)
}

case class RandomNeighbour[A](maxDistance: Option[Int] = None, random: Random = Random) extends NeighbourSelector[A] {
  override def select(a: Individual[A]): (Int, Int) = {
    val maxSize = maxDistance match {
      case None => a.length
      case Some(d) if d < 1 || d >= a.length => a.length
      case Some(d) => d
    }
    val first = random.nextInt(a.length - 1)
    val second = first + 1 + random.nextInt(Math.min(a.length - first - 1, maxSize ) )
    (first, second)
  }
}

case class RandomFixedDistanceNeighbour[A](distance: Int, random: Random = Random) extends NeighbourSelector[A] {
  override def select(a: Individual[A]): (Int, Int) = {
    val safeDistance = if (distance < 1 || distance > a.length) a.length else distance
    val first = random.nextInt(a.length - distance)
    (first, first + distance)
  }
}
