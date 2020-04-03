/*
 *  Copyright © 2020, Petros Papapanagiotou, all rights reserved.
 *  School of Informatics, The University of Edinburgh
 */

package uk.ac.ed.inf.ppapapan.scalevolve

import scala.collection.mutable.ArraySeq

class Individual[A] (val genes: ArraySeq[A]) {
  def length: Int = genes.length

  def copy: Individual[A] = Individual(genes: _*)

  def withFitness(fitness: Double): FitIndividual[A] = FitIndividual(this,fitness)

  override def toString: String = 
    s"[${genes.mkString(",")}]"
}

object Individual {
  def apply[A](genes: A*) = 
    new Individual(ArraySeq(genes: _*))
}

case class FitIndividual[A](i: Individual[A], fitness: Double) 
