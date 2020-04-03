/*
 *  Copyright © 2020, Petros Papapanagiotou, all rights reserved.
 *  School of Informatics, The University of Edinburgh
 */

package uk.ac.ed.inf.ppapapan.scalevolve.selection

import uk.ac.ed.inf.ppapapan.scalevolve.{Individual, FitIndividual}
import scala.util.Random
import scala.annotation.tailrec

case class RouletteWheelSelector[A](random: Random = Random) extends Selector[A] {
  override def select(count: Int, population: Seq[FitIndividual[A]]): Seq[Individual[A]] = {
    val sum = (0.0 /: population) { case (s,i) => s + i.fitness }
    
    val popList = population.toList
    for (_ <- 1 to count) yield get(random.nextDouble() * sum,popList)
  }

  @tailrec
  private def get(p: Double, population: List[FitIndividual[A]], iterSum: Double = 0.0 ) : Individual[A] = population match {
    case Nil => throw new Exception("Tried to select from empty population")
    case h :: Nil => h.i
    case h :: t => if (p < iterSum + h.fitness) h.i else get(p, t, iterSum + h.fitness)
  }
}

