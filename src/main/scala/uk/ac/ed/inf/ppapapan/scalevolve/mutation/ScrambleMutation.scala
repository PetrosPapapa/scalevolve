/*
 *  Copyright © 2020, Petros Papapanagiotou, all rights reserved.
 *  School of Informatics, The University of Edinburgh
 */

package uk.ac.ed.inf.ppapapan.scalevolve.mutation

import uk.ac.ed.inf.ppapapan.scalevolve.Individual
import scala.util.Random
import scala.collection.mutable.ArraySeq

case class ScrambleMutation[A](neighbourSelector: NeighbourSelector[A] = RandomNeighbour[A](None), random: Random = Random) extends Mutation[A] {
  def mutate(a: Individual[A]): Individual[A] = if (a.length < 2) a else {
    val (first, second) = neighbourSelector.select(a)
    val patch = random.shuffle(a.genes.slice(first, second + 1))
    new Individual(a.genes.patch(first, patch, second - first + 1))
  }
}
