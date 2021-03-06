import functions._

/* Adopted from page 31 Scala by Example */
class Rational(n: Int, d: Int) extends AnyRef {

	private def gcd(x: Int, y: Int): Int = {
		if (x == 0) y
		else if (x < 0) gcd(-x, y)
		else if (y < 0) -gcd(x, -y)
		else gcd(y % x, x)
	}

	private val g = gcd(n, d)

	val numer: Int = n / g
	val denom: Int = d / g

	def +(that: Rational) = 
		new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

	def -(that: Rational) =
		new Rational(numer * that.denom - that.numer * denom, denom * that.denom)

	def *(that: Rational) = 
		new Rational(numer * that.numer, denom * that.denom)

	def /(that: Rational) =
		new Rational( numer * that.denom, denom * that.numer)

	def square = new Rational(numer * numer, denom * denom)

	override def toString = "" + numer + "/" + denom

	override def equals(obj: Any) = {
		obj match {
			case that: Rational => (numer == that.numer && denom == that.denom)
			case _ => false
		}
	}
}