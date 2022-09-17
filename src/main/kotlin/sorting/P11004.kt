package sorting

import java.util.*

/**
 * K번째 수
 *
 * 수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다.
 * 둘째에는 A1, A2, ..., AN이 주어진다. (-109 ≤ Ai ≤ 109)
 *
 * Input
 * 5 2
 * 4 1 2 3 5
 *
 * Output
 * 2
 */
class P11004 {
}

fun main(args: Array<String>) {
	val reader = System.`in`.bufferedReader()

	val firstLine = StringTokenizer(reader.readLine(), " ")
	val numCount = firstLine.nextToken().toInt()
	val findIndex = firstLine.nextToken().toInt()

	val secondLine = StringTokenizer(reader.readLine(), " ")
	val nums = (1..numCount).map { secondLine.nextToken().toInt() }.toIntArray()

	println(
		findIndexByQuickSort(nums, 0, numCount - 1, findIndex - 1)
	)
}

fun findIndexByQuickSort(nums: IntArray, left: Int, right: Int, findIndex: Int): Int {
	val pivotIndex = pivot(nums, left, right)

	return if (pivotIndex == findIndex) nums[findIndex]
	else if (pivotIndex > findIndex) findIndexByQuickSort(nums, left, pivotIndex - 1, findIndex)
	else findIndexByQuickSort(nums, pivotIndex + 1, right, findIndex)
}

fun pivot(nums: IntArray, left: Int, right: Int): Int {
	if (left == right) {
		return left
	}

	val pivotValue = nums[right]

	var leftIndex = left
	var rightIndex = right - 1

	while (leftIndex <= rightIndex) {
		// 밑에서부터 Pivot 보다 큰 수 찾기
		while (leftIndex < right && nums[leftIndex] < pivotValue) {
			leftIndex++
		}

		// 위에서부터 Pivot 보다 작은 수 찾기
		while (rightIndex >= 0 && nums[rightIndex] > pivotValue) {
			rightIndex--
		}

		if (leftIndex < rightIndex) {
			swap(nums, leftIndex, rightIndex)
			leftIndex++
			rightIndex--
		}
	}
	swap(nums, leftIndex, right)
	return leftIndex
}

fun swap(nums: IntArray, left: Int, right: Int) {
	val temp = nums[left]
    nums[left] = nums[right]
	nums[right] = temp
}
