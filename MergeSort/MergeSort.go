package main
import "fmt"

func sortedMerge(firstList []int, secondList []int) []int {
	var mergedList []int
	var firstListIndex, secondListIndex int = 0,0

	for len(mergedList) < (len(firstList) + len(secondList)) {

		if firstList[firstListIndex] < secondList[secondListIndex] {
			mergedList = append(mergedList, firstList[firstListIndex])
			firstListIndex++
		} else {
			mergedList = append(mergedList, secondList[secondListIndex])
			secondListIndex++
		}
		
		if firstListIndex == len(firstList) {
			mergedList = append(mergedList, secondList[secondListIndex:]...)
		}

		if secondListIndex == len(secondList) {
			mergedList = append(mergedList, firstList[firstListIndex:]...)
		}
	}
	return mergedList
}

func sort(inputList []int) []int {
	var inputLength int = len(inputList)
	if inputLength > 1 {
		return sortedMerge(sort(inputList[0:inputLength/2]), sort(inputList[inputLength/2:inputLength]))
	} else {
		return inputList
	}
}

func main() {
	fmt.Println("sort(2, 6, 3, 9, 1, 5) => ", sort([]int{2, 6, 3, 9, 1, 5}))
	fmt.Println("sort(2, 6, 3, 9, 1) => ", sort([]int{2, 6, 3, 9, 1}))
}