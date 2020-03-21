/*
 *  Copyright © 2020, Petros Papapanagiotou, all rights reserved.
 *  School of Informatics, The University of Edinburgh
 */

package uk.ac.ed.inf.ppapapan.scalevolve.mutation

import uk.ac.ed.inf.ppapapan.scalevolve.Individual
import scala.util.Random
import scala.collection.mutable.ArraySeq

case class SwapMutation[A](random: Random = Random) {
  def mutate(a: Individual[A]): Individual[A] = if (a.length < 2) a else {
    val first = random.nextInt(a.length)
    val second = random.nextInt(a.length) // it might be the same, and we are ok with that!
    val result = a.copy
    result.genes.update(first, a.genes(second))
    result.genes.update(second, a.genes(first))
    result
  }
}
