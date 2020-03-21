/*
 *  Copyright © 2020, Petros Papapanagiotou, all rights reserved.
 *  School of Informatics, The University of Edinburgh
 */

package uk.ac.ed.inf.ppapapan.scalevolve.mutation

import org.scalatest.WordSpecLike
import org.scalatest.Matchers
import scala.collection.mutable.ArraySeq
import uk.ac.ed.inf.ppapapan.scalevolve.Individual

class MutationTests extends WordSpecLike with Matchers {

  "SwapMutation" must {
    "keep the original individual as it was" in {
      val i = Individual(1,2,3,4)
      val j = SwapMutation[Int]().mutate(i)
      i should not be (j)
    }
  }
}
