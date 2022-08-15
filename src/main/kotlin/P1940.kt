package doit

import java.util.*

/**
 * 주몽
 * https://www.acmicpc.net/problem/1940
 *
 * 주몽은 철기군을 양성하기 위한 프로젝트에 나섰다.
 * 그래서 야철대장을 통해 철기군이 입을 갑옷을 만들게 하였다. 야철대장은 주몽의 명에 따르기 위하여 연구에 착수하던 중 아래와 같은 사실을 발견하게 되었다.
 * 갑옷을 만드는 재료들은 각각 고유한 번호를 가지고 있다.
 * 갑옷은 두 개의 재료로 만드는데 두 재료의 고유한 번호를 합쳐서 M(1 ≤ M ≤ 10,000,000)이 되면 갑옷이 만들어 지게 된다.
 * 야철대장은 자신이 만들고 있는 재료를 가지고 갑옷을 몇 개나 만들 수 있는지 궁금해졌다.
 * 이러한 궁금증을 풀어 주기 위하여 N(1 ≤ N ≤ 15,000) 개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지를 구하는 프로그램을 작성하시오.
 *
 *  - 입력
 * 첫째 줄에는 재료의 개수 N(1 ≤ N ≤ 15,000)이 주어진다.
 * 그리고 두 번째 줄에는 갑옷을 만드는데 필요한 수 M(1 ≤ M ≤ 10,000,000) 주어진다.
 * 그리고 마지막으로 셋째 줄에는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다.
 * 고유한 번호는 100,000보다 작거나 같은 자연수이다.
 *
 * Input
 * 6
 * 9
 * 2 7 4 1 5 3
 */
class P1940 {
}

fun main() {
	val sc = Scanner(System.`in`)

	val inputCount = sc.nextInt()
	val requiredNum = sc.nextInt()

	val nums = (1..inputCount).map { sc.nextInt() }.sorted()

	var startIndex = 0
	var endIndex = nums.size - 1
	var count = 0

	while (startIndex < endIndex) {
		val currentSum = nums[startIndex] + nums[endIndex]
		if (currentSum == requiredNum) {
			count++
			startIndex++
			endIndex--
		} else if (currentSum < requiredNum) {
			startIndex++
		} else if (currentSum > requiredNum) {
			endIndex--
		}
	}
	println(count)
}