package graph

import java.util.*

/**
 * 연결 요소의 개수
 *
 * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 */
class P11004 {
}

fun main(args: Array<String>) {
	val reader = System.`in`.bufferedReader()

	var st = StringTokenizer(reader.readLine(), " ")
	val nodeCount = st.nextToken().toInt()
	val edgeCount = st.nextToken().toInt()

	var visited = BooleanArray(nodeCount + 1)
	var nodeList = mutableMapOf<Int, MutableList<Int>>()

	(1..edgeCount).forEach {
		st = StringTokenizer(reader.readLine(), " ")
		val start = st.nextToken().toInt()
		val end = st.nextToken().toInt()

		nodeList.putIfAbsent(start, mutableListOf(end))?.add(end)
		nodeList.putIfAbsent(end, mutableListOf(start))?.add(start)
	}

	var dfsCount = 0
	(1..nodeCount).forEach { node ->
		if (!visited[node]) {
			dfs(node, nodeList, visited)
			dfsCount++
		}
	}
	println(dfsCount)
}

fun dfs(node: Int, nodeList: Map<Int, List<Int>>, visited: BooleanArray) {
	if (visited[node]) {
		return
	}

	visited[node] = true
	nodeList[node]?.forEach { dfs(it, nodeList, visited) }
}
