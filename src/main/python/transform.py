from pyspark import since, keyword_only, SparkContext
from pyspark.rdd import ignore_unicode_prefix
from pyspark.ml.linalg import _convert_to_vector
from pyspark.ml.param.shared import *
from pyspark.ml.util import JavaMLReadable, JavaMLWritable
from pyspark.ml.wrapper import JavaEstimator, JavaModel, JavaParams, JavaTransformer, _jvm

class Testing(JavaTransformer, JavaMLReadable, JavaMLWritable):

    number = Param(Params._dummy(), "number","this is a number",typeConverter=TypeConverters.toFloat)

    name = Param(Params._dummy(), "name","this is a name",typeConverter=TypeConverters.toString)

    @keyword_only
    def __init__(self):
        super(Testing, self).__init__()
        self._java_obj = self._new_java_obj("org.favila.spark.poc.transforms.Sample", self.uid)
        kwargs = self._input_kwargs
        self.setParams(**kwargs)

    @keyword_only
    def setParams(self, number=0.0, name="No Name"):
        kwargs = self._input_kwargs
        return self._set(**kwargs)

    def setNumber(self, value):
        return self._set(number=value)

    def getNumber(self):
        return self.getOrDefault(self.number)

    def setName(self, value):
        return self._set(name=value)

    def getName(self):
        return self.getOrDefault(self.name)
