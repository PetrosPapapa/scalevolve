/*
 *  Copyright © 2020, Petros Papapanagiotou, all rights reserved.
 *  School of Informatics, The University of Edinburgh
 */

package uk.ac.ed.inf.ppapapan.scalevolve.crossover

import uk.ac.ed.inf.ppapapan.scalevolve.Individual

trait Crossover {
  def gen[A](a: Individual[A], b: Individual[A]): Seq[Individual[A]]
}
