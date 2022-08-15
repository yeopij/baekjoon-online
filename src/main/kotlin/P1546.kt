package doit

import java.util.*

class P1546 {
}

fun main() {
	val sc: Scanner = Scanner(System.`in`)

	val count = sc.nextInt()
	val nums = IntRange(1, count).map { sc.nextInt() }
	val max = nums.maxOrNull() ?: 1

	println(nums.sum().toDouble() * 100 / count / max)
}