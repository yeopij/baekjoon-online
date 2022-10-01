package search

import java.util.*

/**
 * 원하는 정수 찾기
 */
class P1167 {
}

fun main() {
	val reader = System.`in`.bufferedReader()

	val M = reader.readLine().toInt()
	val givenSet = StringTokenizer(reader.readLine(), " ").asSequence().map {
		it.toString().toInt()
	}.toSet()

	val N = reader.readLine().toInt()
	StringTokenizer(reader.readLine(), " ").asSequence().forEach {
		val exist = givenSet.contains(it.toString().toInt())
		println(if (exist) "1" else "0")
	}
}