/*
 *  Copyright © 2020, Petros Papapanagiotou, all rights reserved.
 *  School of Informatics, The University of Edinburgh
 */

package uk.ac.ed.inf.ppapapan.scalevolve.crossover

import org.scalatest.WordSpecLike
import org.scalatest.Matchers
import scala.collection.mutable.ArraySeq

class CrossoverTests extends WordSpecLike with Matchers {

  "The PointCrossover Object" must {
    "no-point crossover ArraySeq's correctly" in {
      val l = ArraySeq(1,1,1,1)
      val r = ArraySeq(2,2,2,2)
      PointCrossover.crossover(l,r,List()) should be ((ArraySeq(1,1,1,1), ArraySeq(2,2,2,2)))
    }

    "one-point crossover ArraySeq's correctly" in {
      val l = ArraySeq(1,1,1,1)
      val r = ArraySeq(2,2,2,2)
      PointCrossover.crossover(l,r,List(1)) should be ((ArraySeq(1,2,2,2), ArraySeq(2,1,1,1)))
    }
    
    "two-point crossover ArraySeq's correctly" in {
      val l = ArraySeq(1,1,1,1)
      val r = ArraySeq(2,2,2,2)
      PointCrossover.crossover(l,r,List(1,2)) should be ((ArraySeq(1,2,1,1), ArraySeq(2,1,2,2)))
    }

    "three-point crossover ArraySeq's correctly" in {
      val l = ArraySeq(1,1,1,1)
      val r = ArraySeq(2,2,2,2)
      PointCrossover.crossover(l,r,List(1,2,3)) should be ((ArraySeq(1,2,1,2), ArraySeq(2,1,2,1)))
    }

    "one-point crossover ArraySeq's at root correctly" in {
      val l = ArraySeq(1,1,1,1)
      val r = ArraySeq(2,2,2,2)
      PointCrossover.crossover(l,r,List(0)) should be ((ArraySeq(2,2,2,2), ArraySeq(1,1,1,1)))
    }
  }
}

