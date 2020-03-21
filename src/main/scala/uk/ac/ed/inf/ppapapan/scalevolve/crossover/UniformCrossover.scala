/*
 *  Copyright © 2020, Petros Papapanagiotou, all rights reserved.
 *  School of Informatics, The University of Edinburgh
 */

package uk.ac.ed.inf.ppapapan.scalevolve.crossover

import scala.collection.mutable.ArraySeq
import uk.ac.ed.inf.ppapapan.scalevolve.Individual
import scala.util.Random

case class UniformCrossover[A](p: Float = 0.5f, random: Random = Random) extends Crossover[A] {
  override def gen(a: Individual[A], b: Individual[A]): Seq[Individual[A]] = {
    val length = Math.min(a.genes.length, b.genes.length)
    val l = new ArraySeq[A](length)
    val r = new ArraySeq[A](length)
    for (i <- 0 until length) {
      val rand = random.nextFloat()
      if (rand < p) {
        l.update(i, b.genes(i))
        r.update(i, a.genes(i))
      } else {
        l.update(i, a.genes(i))
        r.update(i, b.genes(i))
      }
    }
    Seq( new Individual(l), new Individual(r) )
  }
}
