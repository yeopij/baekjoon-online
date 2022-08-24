package sorting

import java.util.*

/**
 * 수 정렬하기
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
 * 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 */

fun main() {
	val sc = Scanner(System.`in`)

	val count = sc.nextInt()
	val nums = IntRange(1, count).map { sc.nextInt() }.toMutableList()

	//버블소트
	var changed = true
	while (changed) {
		changed = false
		for (index in 0..nums.size - 2) {
			val first = nums[index]
			val second = nums[index + 1]
			if (first > second) {
				nums[index] = second
				nums[index + 1] = first
				changed = true
			}
		}
	}
	nums.forEach { println(it) }

//	nums.sorted().forEach { println(it) }
}