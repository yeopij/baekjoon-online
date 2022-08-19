import java.util.*

/**
 * 블로그
 *
 * 찬솔이는 블로그를 시작한 지 벌써 $N$일이 지났다.
 * 요즘 바빠서 관리를 못 했다가 방문 기록을 봤더니 벌써 누적 방문 수가 6만을 넘었다.
 * 첫째 줄에 블로그를 시작하고 지난 일수 $N$와 $X$가 공백으로 구분되어 주어진다.
 * 둘째 줄에는 블로그 시작 $1$일차부터 $N$일차까지 하루 방문자 수가 공백으로 구분되어 주어진다.
 * 첫째 줄에 $X$일 동안 가장 많이 들어온 방문자 수를 출력한다. 만약 최대 방문자 수가 0명이라면 SAD를 출력한다.
 * 만약 최대 방문자 수가 0명이 아닌 경우 둘째 줄에 기간이 몇 개 있는지 출력한다.
 *
 * Input
 * 5 2
 * 1 4 2 5 1
 *
 * Output
 * 7
 * 1
 */
class P21921 {
}

fun main(args: Array<String>) {
	val sc = Scanner(System.`in`)
	val count = sc.nextInt()
	val duration = sc.nextInt()

	val counts = (1..count).map {
		sc.nextInt()
	}

	//초기 슬라이딩 설정
	var startIndex = 0
	var endIndex = duration - 1

	var currentSum = (startIndex..endIndex).map { counts[it] }.sum()
	var maxSum = currentSum
	var maxCount = 1

	//슬라이딩 이동
	while (endIndex < counts.size - 1) {
		currentSum = currentSum - counts[startIndex] + counts[endIndex + 1]
		if (currentSum > maxSum) {
			maxSum = currentSum
			maxCount = 1
		} else if (currentSum == maxSum) {
			maxCount++
		}
		startIndex++
		endIndex++
	}

	if (maxSum == 0) {
		println("SAD")
	} else {
		println(maxSum)
		println(maxCount)
	}
}