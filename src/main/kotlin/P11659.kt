import java.util.*

/**
 * 구간 합 구하기 4
 *
 * 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
 * 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다.
 * 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
 * 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
 *
 * Input
 * 5 3
 * 5 4 3 2 1
 * 1 3
 * 2 4
 * 5 5
 *
 * Output
 * 12
 * 9
 * 1
 */
fun main() {
	val sc = Scanner(System.`in`)

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