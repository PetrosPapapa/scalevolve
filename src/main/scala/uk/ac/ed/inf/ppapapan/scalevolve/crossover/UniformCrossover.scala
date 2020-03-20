/*
 *  Copyright © 2020, Petros Papapanagiotou, all rights reserved.
 *  School of Informatics, The University of Edinburgh
 */

package uk.ac.ed.inf.ppapapan.scalevolve.crossover

import scala.collection.mutable.ArraySeq
import uk.ac.ed.inf.ppapapan.scalevolve.Individual
import scala.util.Random

case class UniformCrossover(p: Float = 0.5f) extends Crossover {
  override def gen[A](a: Individual[A], b: Individual[A]): Seq[Individual[A]] = {
    val length = Math.min(a.chromosomes.length, b.chromosomes.length)
    val l = new ArraySeq[A](length)
    val r = new ArraySeq[A](length)
    for (i <- 0 until length) {
      val rand = scala.util.Random.nextFloat()
      if (rand < p) {
        l.update(i, b.chromosomes(i))
        r.update(i, a.chromosomes(i))
      } else {
        l.update(i, a.chromosomes(i))
        r.update(i, b.chromosomes(i))
      }
    }
    Seq( Individual(l), Individual(r) )
  }
}
