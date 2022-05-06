import org.scalatest._
import flatspec._
import matchers._
import Traverser._

import java.io.File

class DirectorySpec extends AnyFlatSpec with should.Matchers {

  it should "traverse given directory" in {

    val dir = new File(".\\src")
    traverse(dir) shouldBe Array(
      ".\\src\\main",
      ".\\src\\test",
      ".\\src\\main\\scala",
      ".\\src\\main\\scala\\Traverser.scala",
      ".\\src\\main\\scala\\ws.sc",
      ".\\src\\test\\scala",
      ".\\src\\test\\scala\\TraverserSpec.scala")
  }
}