/* How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100? */
class s29 extends Solution {
	//TODO Scalify this for practice.
	def solve() = {
		val all = for (a <- 2 to 100; b <- 2 to 100) yield BigInt(a).pow(b)
		all.distinct.size.toString
	}
}