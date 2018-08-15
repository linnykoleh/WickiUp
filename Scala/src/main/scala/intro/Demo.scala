package intro

object Demo {

  def main(args: Array[String]) {
    printInterpolation
    ifElse
    loops
  }

  protected def printInterpolation = {
    println("================printInterpolation================")
    val name = "mark"
    val age = 18

    printf("Hello %s your age is %d \n", name, age)
    println(s"Hello $name your age is $age")
    println(raw"Hello \nworld")

    println("==============printInterpolation================")
  }

  private def ifElse= {
    println("================ifElse================")
    val x = 20
    val y = 30
    val a = 30
    var res = ""

    if(x == 20 && y != 30 || a > 30){
      res = "x == 20"
    }else {
      res = "x != 20"
    }
    println("Res = " + res)

    val res2 = if (x == 20) "x == 20" else "x != 20"
    println("Res2 = " + res2)

    println("================ifElse================")
  }

  def loops = {
    println("================loops================")
    var x = 0

    while (x < 5){
      println("x = " +x)
      x += 1
//      x++; No, compile error
    }

    x = 0
    do {
      println("x = " +x)
      x += 1
    } while (x < 5)

    println("================loops================")
  }
}
