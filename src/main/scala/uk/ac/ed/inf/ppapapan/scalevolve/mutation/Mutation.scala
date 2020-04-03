/*
 *  Copyright © 2020, Petros Papapanagiotou, all rights reserved.
 *  School of Informatics, The University of Edinburgh
 */

package uk.ac.ed.inf.ppapapan.scalevolve.mutation

import uk.ac.ed.inf.ppapapan.scalevolve.Individual

trait Mutation[A] {
  def mutate(a: Individual[A]): Individual[A]
}

