package doit

import java.util.*

/**
 * 수들의 합
 * https://www.acmicpc.net/problem/1789
 *
 * 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
 *
 * Input
 * 200
 *
 * Output
 * 19
 */
class P1789 {
}

fun main() {
	val sc = Scanner(System.`in`)

	val num = sc.nextLong()

	var sum: Long = 0
	var count = 0

	(1..num).forEach {
		sum += it
		count++

		if (sum == num) {
			println(count)
			return
		} else if (sum > num) {
			println(count - 1)
			return
		}
	}
}