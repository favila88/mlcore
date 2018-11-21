package org.favila.spark.poc.api

import org.favila.spark.poc.containers.Data
import org.favila.spark.poc.transforms.Sample

class Api {

  def foo(dat :Data, name: String, number: Double): Data = {
    val df = dat.getDF()
    val samp = new Sample()
      .setNumber(number)
      .setName(name)
    val newDf = samp.transform(df)
    new Data(newDf)
  }

}
