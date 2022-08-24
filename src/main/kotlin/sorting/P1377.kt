package sorting

import java.util.*
import kotlin.math.max

/**
 * 버블소트
 */
fun main() {
	val sc = Scanner(System.`in`)

	val count = sc.nextInt()

	val nums = mutableListOf<Pair<Int, Int>>()
	for (i in 0 until count) {
		nums.add(i to sc.nextInt())
	}

	//가장 인덱스 차이가 많이 나는 인덱스 찾기
	var maxDiff = 0
	nums.sortedBy { it.second }
		.forEachIndexed { index, node ->
			val diff = node.first - index
			maxDiff = max(maxDiff, diff)
		}
	println(maxDiff + 1)
}
