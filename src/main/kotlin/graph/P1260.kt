package graph

import java.util.*

/**
 * DFS와 BFS
 */

class P1260 {
}

fun main() {
	val reader = System.`in`.bufferedReader()

	var st = StringTokenizer(reader.readLine(), " ")
	val nodeCount = st.nextToken().toInt()
	val edgeCount = st.nextToken().toInt()
	val startNode = st.nextToken().toInt()

	val nodeList = mutableMapOf<Int, MutableList<Int>>()

	(1..edgeCount).forEach {
		st = StringTokenizer(reader.readLine(), " ")
		val start = st.nextToken().toInt()
		val end = st.nextToken().toInt()

		nodeList.putIfAbsent(start, mutableListOf(end))?.add(end)
		nodeList.putIfAbsent(end, mutableListOf(start))?.add(start)
	}

	println(dfs(nodeList, startNode, BooleanArray(nodeCount + 1)).joinToString(separator = " ") { it.toString() })
	println(bfs(nodeList, startNode, BooleanArray(nodeCount + 1)).joinToString(separator = " ") { it.toString() })
}

fun dfs(nodeList: Map<Int, List<Int>>, node: Int, visited: BooleanArray): List<Int> {
	if (visited[node]) {
		return emptyList()
	}

	visited[node] = true
	return listOf(node) +
		(nodeList[node]?.sorted()?.map {
			dfs(nodeList, it, visited)
		}?.flatten() ?: emptyList()
	)
}

fun bfs(nodeList: Map<Int, List<Int>>, node: Int, visited: BooleanArray): List<Int> {
	val results = mutableListOf(node)
	val queue = ArrayDeque(nodeList[node]?.sorted() ?: emptyList())
	visited[node] = true

	while (queue.isNotEmpty()) {
		val currentNode = queue.poll()
		if (!visited[currentNode]) {
			visited[currentNode] = true
			results.add(currentNode)

			queue.addAll(nodeList[currentNode]?.sorted() ?: emptyList())
		}
	}
	return results
}
