package graph

import java.util.*
import kotlin.math.sqrt

/**
 * 트리의 지름
 *
 * 트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 트리의 지름을 구하는 프로그램을 작성하시오.
 *
 * Input
 * 5
 * 1 3 2 -1
 * 2 4 4 -1
 * 3 1 2 4 3 -1
 * 4 2 4 3 3 5 6 -1
 * 5 4 6 -1
 */
class P1167 {
}

fun main() {
	val reader = System.`in`.bufferedReader()

	var nodeCount = reader.readLine().toInt()
	var nodeMap = (1..nodeCount).map {
		val st = StringTokenizer(reader.readLine(), " ")

		val node = st.nextToken().toInt()
		val childNodes = mutableListOf<NodeEdge>()
		while (true) {
			val childNode = st.nextToken().toInt()
			if (childNode == -1 ) {
				break
			}
			childNodes.add(NodeEdge(childNode, st.nextToken().toInt()))
		}
		node to childNodes
	}.toMap()

	//특정 시점에서의 반대쪽 노드 찾기
	val opposite = findOppositeNodeByBFS(nodeMap, nodeMap.keys.first())
	//반대쪽에서 다른 반대쪽 노트 찾기
	println(findOppositeNodeByBFS(nodeMap, opposite.first).second)
}

fun findOppositeNodeByBFS(nodeList: Map<Int, List<NodeEdge>>, startNode: Int): Pair<Int, Int> {
	var distances = mutableMapOf(startNode to 0)
	var queue = ArrayDeque<Int>()
	queue.add(startNode)

	while (queue.isNotEmpty()) {
		val parent = queue.poll()
		nodeList[parent]?.forEach { child ->
			if (!distances.containsKey(child.node)) {
				distances.put(child.node, child.value + (distances[parent] ?: 0))
				queue.add(child.node)
			}
		}
	}
	return distances.toList().maxByOrNull { it.second }!!
}

data class NodeEdge(
	val node: Int,
	val value: Int
)