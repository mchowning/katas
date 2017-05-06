package example

class NinetyNineBottles {

  def song(): String = verses(99, 0)

  def verses(start: Int, end: Int): String =
    (start to end by -1)
      .map { n => verse(n) }
      .mkString

  def verse(num: Int): String = {

    def getBottles(n: Int): String = n match {
      case 0  => "no more bottles"
      case 1  => s"$n bottle"
      case -1 => "99 bottles"
      case _  => s"$n bottles"
    }

    def getTakeDown(n: Int): String = n match {
      case 0 => "Go to the store and buy some more"
      case 1 => "Take it down and pass it around"
      case _ => "Take one down and pass it around"
    }

    s"""
      |${getBottles(num).capitalize} of beer on the wall, ${getBottles(num)} of beer.
      |${getTakeDown(num)}, ${getBottles(num-1)} of beer on the wall.
      |""".stripMargin
  }
}
