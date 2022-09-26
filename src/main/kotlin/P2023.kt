import java.util.*
import kotlin.math.sqrt

/**
 * 신기한 소수 찾기
 */

class P2023 {
}

fun main() {
	val sc = Scanner(System.`in`)

	val digit = sc.nextInt()

	findPrimeNumber(digit)
}

fun findPrimeNumber(findDigit: Int, num: Int = 0, digit: Int = 0) {
	if (findDigit == digit) {
		println(num)
		return
	}

	IntRange(0, 9).forEach {
		val number = num * 10 + it
		if (isPrimeNumber(number)) {
			findPrimeNumber(findDigit, number, digit + 1)
		}
	}
}

fun isPrimeNumber(num: Int): Boolean {
	if (num == 2) return true

	if (num < 2 || num % 2 == 0) {
		return false
	}

	for (i in 3..sqrt(num.toDouble()).toInt() step 2) {
		if (num % i == 0) {
			return false
		}
	}
	return true
}