import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayDeque

/**
 * 최솟값 찾기
 *
 * N개의 수 A1, A2, ..., An과 L이 주어진다.
 * Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오.
 * 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.
 *
 * Input
 * 12 3
 * 1 5 2 3 6 2 3 7 3 5 2 6
 *
 * Output
 * 1 1 1 2 2 2 2 2 3 3 2 2
 */
class P11003 {
}

fun main(args: Array<String>) {
	val sc = Scanner(System.`in`)
	val count = sc.nextInt()
	val windowSize = sc.nextInt()

	//Left : Index, Right : Value의 Pair를 가지는 Deque
	val deque = ArrayDeque<Node>()
	val nums = (1..count).map { sc.nextInt() }

	val bw = BufferedWriter(OutputStreamWriter(System.out))

	nums.forEachIndexed { index, num ->
		//뒤에서 부터 신규 항목 보다 값이 작은 항목 제거 및 신규 항목 추가
		while (deque.isNotEmpty() && deque.last().value >= num) {
			deque.removeLast()
		}
		deque.addLast(Node(index, num))

		//최소값 확인 전 맨 앞에 위치한 항목이 범위를 벗어 났을 경우 처리
		if (deque.first().index <= index - windowSize) {
			deque.removeFirst()
		}
		bw.write(deque.first().value.toString() + " ")
	}
	bw.flush()
	bw.close()
}

data class Node(
	val index: Int,
	val value: Int
)