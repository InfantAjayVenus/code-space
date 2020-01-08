package main

import "fmt"

func sortedInsert(inputList []int, pivotElement int) int {
	var forwardIndex, backwardIndex int = 0,len(inputList)-1
	
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

func sort(inputList []int) []int  {
	if len(inputList) > 1 {
		var updatedPivotPosition int = sortedInsert(inputList, inputList[0])
		sort(inputList[0:updatedPivotPosition])
		sort(inputList[updatedPivotPosition+1:len(inputList)])
	} 

	return inputList
}

func main() {
	fmt.Println("sort(2, 6, 3, 9, 1, 5) =>", sort([]int{2, 6, 3, 9, 1, 5}))
	fmt.Println("sort(2, 6, 3, 9, 1) =>", sort([]int{2, 6, 3, 9, 1}))
}