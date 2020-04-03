/*
 *  Copyright © 2020, Petros Papapanagiotou, all rights reserved.
 *  School of Informatics, The University of Edinburgh
 */

package uk.ac.ed.inf.ppapapan.scalevolve.mutation

import uk.ac.ed.inf.ppapapan.scalevolve.Individual
import scala.collection.mutable.ArraySeq

case class SwapMutation[A](neighbourSelector: NeighbourSelector[A] = RandomNeighbour[A](None)) extends Mutation[A] {
  def mutate(a: Individual[A]): Individual[A] = if (a.length < 2) a else {
    val (first, second) = neighbourSelector.select(a)
    val result = a.copy
    result.genes.update(first, a.genes(second))
    result.genes.update(second, a.genes(first))
    result
  }
}
