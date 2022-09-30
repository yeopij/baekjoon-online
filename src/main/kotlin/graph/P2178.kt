package graph

import java.util.*

/**
 * 미로 탐색하기
 */

class P2178 {
}

fun main() {
	val reader = System.`in`.bufferedReader()

	var st = StringTokenizer(reader.readLine(), " ")
	val rowCount = st.nextToken().toInt()
	val columnCount = st.nextToken().toInt()

	val matrix = Array(rowCount) {
		IntArray(columnCount) { 0 }
	}

	(1..rowCount).forEachIndexed { row, i ->
		reader.readLine().toCharArray().forEachIndexed { colmun, char ->
			matrix[row][colmun] = Integer.parseInt(char.toString())
		}
	}

	//BFS Search
	var depth = 1
	var visited = mutableSetOf(Pair(0, 0))
	var queue = ArrayDeque(findValidPath(matrix, Pair(0, 0)))

	while (queue.isNotEmpty()) {
		depth++

		var nextQueue = mutableSetOf<Pair<Int, Int>>()
		while (queue.isNotEmpty()) {
			val currentPoint = queue.poll()
			if (!visited.contains(currentPoint)) {
				visited.add(currentPoint)
				if (currentPoint == Pair(rowCount - 1, columnCount - 1)) {
					println(depth)
					return
				}
				nextQueue.addAll(findValidPath(matrix, currentPoint))
			}
		}
		queue.addAll(nextQueue)
	}
}

fun findValidPath(matrix: Array<IntArray>, point: Pair<Int, Int>): List<Pair<Int, Int>> {
	var result = mutableListOf<Pair<Int, Int>>()

	//위쪽
	if (point.first > 0 && matrix[point.first - 1][point.second] == 1) {
		result.add(Pair(point.first - 1, point.second))
	}

	//왼쪽
	if (point.second > 0 && matrix[point.first][point.second - 1] == 1) {
		result.add(Pair(point.first, point.second - 1))
	}

	//오른쪽
	if (point.second < matrix[point.first].size - 1 && matrix[point.first][point.second + 1] == 1) {
		result.add(Pair(point.first, point.second + 1))
	}

	//아래쪽
	if (point.first < matrix.size -1 && matrix[point.first +1][point.second] == 1) {
		result.add(Pair(point.first + 1, point.second))
	}
	return result
}