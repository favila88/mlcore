package org.favila.spark.poc.transforms


import org.apache.spark.annotation.Since
import org.apache.spark.ml.Transformer
import org.apache.spark.ml.attribute.BinaryAttribute
import org.apache.spark.ml.linalg._
import org.apache.spark.ml.param._
import org.apache.spark.ml.param.shared.{HasInputCol, HasOutputCol}
import org.apache.spark.ml.util._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._


class Sample(override val uid: String) extends Transformer  {

  def this() = this(Identifiable.randomUID("sample"))

  val number: Param[Double] = new Param[Double](this, "number", "this is a number")

  def getNumber: Double = $(number)

  def setNumber(value: Double): this.type = set(number, value)

  setDefault(number -> 0.0)


  val name: Param[String] = new Param[String](this, "name", "this is a name")

  def getName: String = $(name)

  def setName(value: String): this.type = set(name, value)

  setDefault(name -> "Transform has no name")


  override def transform(ds: Dataset[_]): DataFrame = {

    println("hey my name is: " + getName)
    println("hey my number is: " + getNumber)

    println("here comes the dataFrame: ")

    ds.show()

    ds.toDF()
  }

  override def transformSchema(schema: StructType): StructType = {
    null
  }

  override def copy(extra: ParamMap): Sample = defaultCopy(extra)

}
