package doit

import java.util.*

fun main() {
	val sc: Scanner = Scanner(System.`in`)

	val matrixSize = sc.nextInt()
	val questionLength = sc.nextInt()

	val sumMatrix = arrayListOf<List<Int>>()
	for (i in 0 until matrixSize) {
		val sum = arrayListOf<Int>()
		for (j in 0 until matrixSize) {
			if (j == 0) {
				sum.add(sc.nextInt())
			} else {
				sum.add(sc.nextInt() + sum[j - 1])
			}
		}
		sumMatrix.add(sum)
	}

	IntRange(1, questionLength).map {
		val fromX = sc.nextInt()
		val fromY = sc.nextInt()
		val toX = sc.nextInt()
		val toY = sc.nextInt()

		IntRange(fromY, toY).map { y -> rangeSum(sumMatrix[y - 1], fromX, toX) }.sum()
	}.onEach { println(it) }
}

fun rangeSum(sums: List<Int>, from: Int, end: Int): Int {
	var prevSumIndex = from - 2
	return sums[end - 1] - (if (prevSumIndex < 0) 0 else sums[prevSumIndex])
}

class P11660 {
}