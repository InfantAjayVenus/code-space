package main

import "fmt"

func sort(inputList []int) []int {
	for index, element := range inputList {
		var elementIndex int = index
		for i := index; i < len(inputList); i++ {
			if element > inputList[i] {
				element = inputList[i]
				elementIndex = i
			}
		}
		inputList[index], inputList[elementIndex] = inputList[elementIndex], inputList[index]
	}
	return inputList
}

func main() {
	fmt.Println("sort(2, 6, 3, 9, 1, 5) => ", sort([]int{2, 6, 3, 9, 1, 5}))
}
