package sorting

import java.util.*
import kotlin.math.max

/**
 * 소트인사이드
 *
 * 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
 */
fun main() {
	val sc = Scanner(System.`in`)

	var num = sc.nextInt()

	val digits = mutableListOf<Int>()
	while (num > 0) {
		digits.add(num % 10)
		num /= 10
	}

	//선택 정렬로 구현
	for (i in 0 until digits.size) {
		var max = i

		for (j in i + 1 until digits.size) {
			if (digits[j] > digits[max]) {
				max = j
			}
		}
		val temp = digits[i]
		digits[i] = digits[max]
		digits[max] = temp
	}

	println(digits.joinToString(separator = ""))
}
