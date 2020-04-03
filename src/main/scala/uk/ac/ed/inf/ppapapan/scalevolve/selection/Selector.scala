/*
 *  Copyright © 2020, Petros Papapanagiotou, all rights reserved.
 *  School of Informatics, The University of Edinburgh
 */

package uk.ac.ed.inf.ppapapan.scalevolve.selection

import uk.ac.ed.inf.ppapapan.scalevolve.{Individual, FitIndividual}

trait Selector[A] {
  def select(count: Int, a: Seq[FitIndividual[A]]): Seq[Individual[A]]
}

