package main

import "fmt"

func sortedPartition(inputList []int, pivotElement int) int {
	var forwardIndex, backwardIndex int = 0, len(inputList) - 1

	for forwardIndex < backwardIndex {
		for inputList[forwardIndex] < pivotElement {
			forwardIndex++
		}

		for inputList[backwardIndex] > pivotElement {
			backwardIndex--
		}

		if forwardIndex < backwardIndex {
			inputList[forwardIndex], inputList[backwardIndex] = inputList[backwardIndex], inputList[forwardIndex]
		}
	}

	return forwardIndex
}

func getKthSmallest(inputList []int, k int) int  {

	if k < 1 || k > len(inputList) {
		return -999;
	}

	var pivotPosition int = sortedPartition(inputList, inputList[0])

	if (pivotPosition + 1) == k {
		return inputList[pivotPosition]
	} else if (pivotPosition + 1) > k {
		return getKthSmallest(inputList[0:pivotPosition], k)
	} else {
		return getKthSmallest(inputList[pivotPosition+1: len(inputList)], k - (pivotPosition + 1))
	}

}

func main() {

	fmt.Println("1st smallest(2, 6, 3, 9, 1, 5) => ", getKthSmallest([]int{2, 6, 3, 9, 1, 5}, 1))
	fmt.Println("4th smallest(2, 6, 3, 9, 1, 5) => ", getKthSmallest([]int{2, 6, 3, 9, 1, 5}, 4))
	fmt.Println("last smallest(2, 6, 3, 9, 1, 5) => ", getKthSmallest([]int{2, 6, 3, 9, 1, 5}, 6))
	fmt.Println("0th smallest(2, 6, 3, 9, 1, 5) => ", getKthSmallest([]int{2, 6, 3, 9, 1, 5}, 0))
	fmt.Println("7th smallest(2, 6, 3, 9, 1, 5) => ", getKthSmallest([]int{2, 6, 3, 9, 1, 5}, 7))

}