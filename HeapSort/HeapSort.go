package main

import "fmt"

func main() {
	fmt.Println("sort(2, 6, 3, 9, 1, 5) => ", sort([]int{2, 6, 3, 9, 1, 5}))
	fmt.Println("sort(2, 6, 3, 9, 1) => ", sort([]int{2, 6, 3, 9, 1}))
}

func sort(inputList []int) []int {
	inputList = buildMaxHeap(inputList)

	for i:= len(inputList) - 1; i >= 0; i-- {
		inputList[i], inputList[0] = inputList[0], inputList[i]
		maxHeapify(inputList[0:i], 0)
	}

	return inputList
}

func buildMaxHeap(inputList []int) []int {
	for i := len(inputList)  / 2; i >= 0; i-- {
		inputList = maxHeapify(inputList, i)
	}

	return inputList;
}

func maxHeapify(inputList []int, rootIndex int) []int {
	var maxIndex int = rootIndex
	var leftChildIndex int = getLeftChildIndex(rootIndex)
	var rightChildIndex int = getRightChildIndex(rootIndex)

	if (leftChildIndex < len(inputList)) && (inputList[maxIndex] < inputList[leftChildIndex]) {
		maxIndex = leftChildIndex
	}

	if (rightChildIndex < len(inputList)) && (inputList[maxIndex] < inputList[rightChildIndex]) {
		maxIndex = rightChildIndex
	}

	if maxIndex != rootIndex {
		inputList[maxIndex], inputList[rootIndex] = inputList[rootIndex], inputList[maxIndex]
		return maxHeapify(inputList, maxIndex)
	}

	return inputList

}

func getLeftChildIndex(parentIndex int) int {
	return 2 * parentIndex + 1
}

func getRightChildIndex(parentIndex int) int {
	return 2 * parentIndex + 2
}