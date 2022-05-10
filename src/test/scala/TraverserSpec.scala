import org.scalatest._
import flatspec._
import matchers._
import Traverser._

import java.io.File

class TraverserSpec extends AnyFlatSpec with should.Matchers {

  it should "traverse given directory" in {
    val V = java.io.File.separatorChar

    val dir = new File("src")
    traverse(dir) shouldBe Array(
      s"src${V}main",
      s"src${V}test",
      s"src${V}main${V}scala",
      s"src${V}main${V}scala${V}Traverser.scala",
      s"src${V}main${V}scala${V}ws.sc",
      s"src${V}test${V}scala",
      s"src${V}test${V}scala${V}TraverserSpec.scala")

    val bsp = new File(".bsp")
    traverse(bsp) shouldBe Array(s".bsp${V}sbt.json")
  }
}