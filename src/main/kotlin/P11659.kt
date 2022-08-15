package doit

import java.util.*

fun main() {
	val sc: Scanner = Scanner(System.`in`)

	val dataLength = sc.nextInt()
	val questionLength = sc.nextInt()

	val sums = arrayListOf<Int>()
	IntRange(1, dataLength).forEachIndexed { index, _ ->
		if (index == 0) {
			sums.add(sc.nextInt())
		} else {
			sums.add(sc.nextInt() + sums[index - 1])
		}
	}

	IntRange(1, questionLength).map { sc.nextInt() to sc.nextInt() }.forEach {
		var prevSumIndex = it.first - 2
		println(sums[it.second - 1] - (if (prevSumIndex < 0) 0 else sums[prevSumIndex]))
	}
}

class P11659 {
}