package search

import java.util.*

/**
 * 기타 레슨
 *
 * 9 3
 * 1 2 3 4 5 6 7 8 9
 */
class P2343 {
}

fun main() {
	val reader = System.`in`.bufferedReader()

	val str1 = StringTokenizer(reader.readLine(), " ")
	val size = str1.nextToken().toInt()
	val count = str1.nextToken().toInt()

	val str2 = StringTokenizer(reader.readLine(), " ")
	val list = (1..size).map { str2.nextToken().toInt() }.toList()

	// 바이너리 서치로 가장 작은 값 중 넣을 수 있는 사이즈가 되는 길이 찾기
	// 시작값은 전체 길이의 평균
	var left = list.maxOrNull() ?: return
	var right = list.sum()

	while (left <= right) {
		var current = (left + right) / 2

		if (isCover(list, current, count)) {
			right = current - 1
		} else {
			left = current + 1
		}
	}
	println(left)
}

fun isCover(list: List<Int>, size: Int, count: Int): Boolean {
	var sum = 0
	var needCount = 0

	list.forEach {
		if (sum + it > size) {
			needCount++
			sum = 0
		}
		sum += it
	}

	if (sum > 0) {
		needCount++
	}
	return count >= needCount
}