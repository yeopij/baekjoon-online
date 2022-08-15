import java.util.*

/**
 * 좋다
 * https://www.acmicpc.net/problem/1253
 * N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.
 * N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.
 * 수의 위치가 다르면 값이 같아도 다른 수이다.
 *
 * Input
 * 10
 * 1 2 3 4 5 6 7 8 9 10
 *
 * Output
 * 8
 */
class P11253 {
}

fun main() {
	val sc = Scanner(System.`in`)

	val nums = IntRange(1, sc.nextInt()).map { sc.nextInt() }.sorted()

	val count = nums.filterIndexed { index, num ->
		var startIndex = 0
		var endIndex = nums.size - 1

		while (startIndex < endIndex) {
			val sum = nums[startIndex] + nums[endIndex]
			when {
				sum == num -> {
					if (startIndex != index && endIndex != index) {
						return@filterIndexed true
					} else if (startIndex == index) {
						startIndex++
					} else if (endIndex == index) {
						endIndex--
					}
				}
				sum > num -> endIndex--
				else -> startIndex++
			}
		}
		false
	}.count()

	//Output
	println(count)
}