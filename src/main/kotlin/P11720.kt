import java.util.*

/**
 * 숫자의 합
 *
 * N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
 *
 * Input
 * 5
 * 54321
 *
 * Output
 * 15
 */
class P11720 {
}

fun main(args: Array<String>) {
	val sc = Scanner(System.`in`)
	val count = sc.nextInt()
	val strNums = sc.next()

	println(strNums.map { it - '0' }.sum())
}