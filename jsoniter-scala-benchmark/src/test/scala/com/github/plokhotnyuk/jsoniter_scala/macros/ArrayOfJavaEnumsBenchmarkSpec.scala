package com.github.plokhotnyuk.jsoniter_scala.macros

class ArrayOfJavaEnumsBenchmarkSpec extends BenchmarkSpecBase {
  private val benchmark = new ArrayOfJavaEnumsBenchmark {
    setup()
  }
  
  "ArrayOfJavaEnumsBenchmark" should {
    "deserialize properly" in {
      benchmark.readCirce() shouldBe benchmark.obj
      benchmark.readJacksonScala() shouldBe benchmark.obj
      benchmark.readJsoniterScala() shouldBe benchmark.obj
      benchmark.readPlayJson() shouldBe benchmark.obj
      benchmark.readUPickle() shouldBe benchmark.obj
    }
    "serialize properly" in {
      toString(benchmark.writeCirce()) shouldBe benchmark.jsonString
      toString(benchmark.writeJacksonScala()) shouldBe benchmark.jsonString
      toString(benchmark.writeJsoniterScala()) shouldBe benchmark.jsonString
      toString(benchmark.preallocatedBuf, benchmark.preallocatedOff, benchmark.writeJsoniterScalaPrealloc()) shouldBe benchmark.jsonString
      toString(benchmark.writePlayJson()) shouldBe benchmark.jsonString
      toString(benchmark.writeUPickle()) shouldBe benchmark.jsonString
    }
  }
}