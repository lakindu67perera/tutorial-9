class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator must be nonzero")

  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1) // Auxiliary constructor for whole numbers

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def neg: Rational = new Rational(-numer, denom)

  override def toString: String = s"$numer / $denom"
}

object RationalTest extends App {
  val x = new Rational(3, 4)
  println(s"x: $x")

  val y = x.neg
  println(s"Negative x: $y")
}
