import java.io.File

object Traverser extends App {

  // usage: docker run [imageName] [path]
//
//  args.length match {
//    case 1 => ??? // traverse directory
//    case _ => ??? // error
//  }

  def traverse(dir: File): Array[String] = {
    val children = dir.listFiles()
    (children ++ children.filter(_.isDirectory).flatMap(traverse)).map(_.toString)
  }


  val f = new File(args(0))
  traverse(f).foreach(println)

  traverse(new File(".\\src")).foreach(println)
}