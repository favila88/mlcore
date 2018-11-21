from pyspark.ml.wrapper import JavaWrapper

df = spark.read.option("inferSchema", "true").option("header", "true").csv("/home/favila/spark/data/flight-data/csv/2015-summary.csv")

data = JavaWrapper._new_java_obj("org.favila.spark.poc.containers.Data",df)

api = JavaWrapper._new_java_obj("org.favila.spark.poc.api.Api")

api.foo(data,"this shit works!",1.0)


