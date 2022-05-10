import java.io.File

object Traverser extends App {
  def traverse(dir: File): Array[String] = {
    val children = dir.listFiles()
    (children ++ children.filter(_.isDirectory).flatMap(traverse)).map(_.toString)
  }

  // assume user cooperates
  // usage: docker run [imageName] [path]
  val f = new File(args(0))
  traverse(f).foreach(println)
}