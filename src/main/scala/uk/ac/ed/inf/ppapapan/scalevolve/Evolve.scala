/*
 *  Copyright © 2020, Petros Papapanagiotou, all rights reserved.
 *  School of Informatics, The University of Edinburgh
 */

package uk.ac.ed.inf.ppapapan.scalevolve

import scala.collection.mutable.ArraySeq

class Individual[A] (val genes: ArraySeq[A]) {
  def length: Int = genes.length

  def copy: Individual[A] = Individual(genes: _*)

  override def toString: String = 
    s"[${genes.mkString(",")}]"
}

object Individual {
  def apply[A](genes: A*) = 
    new Individual(ArraySeq(genes: _*))
}
