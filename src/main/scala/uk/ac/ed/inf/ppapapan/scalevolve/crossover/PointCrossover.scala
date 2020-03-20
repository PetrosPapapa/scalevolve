/*
 *  Copyright © 2020, Petros Papapanagiotou, all rights reserved.
 *  School of Informatics, The University of Edinburgh
 */

package uk.ac.ed.inf.ppapapan.scalevolve.crossover

import scala.collection.mutable.ArraySeq
import scala.annotation.tailrec
import uk.ac.ed.inf.ppapapan.scalevolve.Individual

case class PointCrossover(p: List[Int]) extends Crossover {
  override def gen[A](a: Individual[A], b: Individual[A]): Seq[Individual[A]] = {
    val (l,r) = PointCrossover.crossover(a.chromosomes, b.chromosomes, p)
    Seq( Individual(l), Individual(r) )
  }
}

object PointCrossover {
  @tailrec
  def crossover[A](
    left: ArraySeq[A],
    right: ArraySeq[A],
    indices: List[Int],
    cross: Boolean = true
  ): (ArraySeq[A], ArraySeq[A]) = indices match {
    case Nil => (left, right)
    case i :: t => {
      val end = t.headOption.getOrElse(left.length)
      val newLeft = if (!cross) left else left.patch(i, right.slice(i, end), end - i)
      val newRight = if (!cross) right else right.patch(i, left.slice(i, end), end - i)
      crossover(newLeft, newRight, t, !cross)
    }
  }

  def apply(p: Int*): PointCrossover = PointCrossover(p.toList)
}
