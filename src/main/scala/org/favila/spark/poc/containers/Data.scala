package org.favila.spark.poc.containers

import org.apache.spark.sql.DataFrame

class Data (df: DataFrame){

  def getDF(): DataFrame ={
    df
  }

}
