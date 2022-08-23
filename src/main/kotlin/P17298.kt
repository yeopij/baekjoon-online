import java.util.*

/**
 * 오큰수
 *
 * 크기가 N인 수열 A = A1, A2, ..., An이 있다.
 * 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다.
 * Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
 * 그러한 수가 없는 경우에 오큰수는 -1이다.
 *
 * 예를 들어, A = [3, 5, 2, 7]인 경우
 * NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다.
 * A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.
 *
 * Input
 * 4
 * 3 5 2 7
 *
 * Output
 * 5 7 7 -1
 */
class P17298 {
}

fun main(args: Array<String>) {
	val sc = Scanner(System.`in`)
	val nums = (1..sc.nextInt()).map { sc.nextInt() }

	val stack = Stack<Node17298>()

	val ngeMap = mutableMapOf<Int, Int>()
	nums.forEachIndexed { index, value ->
		if (stack.isNotEmpty() && stack.peek().value < value) {
		}
		while (stack.isNotEmpty() && stack.peek().value < value) {
			ngeMap[stack.pop().index] = value
		}
		stack.push(Node17298(index, value))
	}
	println(nums.mapIndexed { index, _ ->
		ngeMap.getOrDefault(index, -1)
	}.joinToString(separator = " "))
}

data class Node17298(
	val index: Int,
	val value: Int
)

