package doit

import java.util.*

class P11720 {

}

fun main(args: Array<String>) {
	val sc: Scanner = Scanner(System.`in`)
	val count = sc.nextInt()
	val strNums = sc.next()
	println(strNums.map { it - '0' }.sum())
}