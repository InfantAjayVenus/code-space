package main

import "fmt"

func getGCD(firstNum int, secondNum int) int {
	if firstNum < secondNum {
		firstNum, secondNum = secondNum, firstNum
	}
	if secondNum > 0 {
		return getGCD(secondNum, firstNum%secondNum)
	} else {
		return firstNum
	}
}

func getGCDofList(numberList []int) int {
	var result int = numberList[0]
	for i := 1; i < len(numberList); i++ {
		result = getGCD(numberList[i], result)
	}
	return result
}

func main() {
	fmt.Println("GCD(24, 62, 194) => ", getGCDofList([]int{24, 62, 194}))
	fmt.Println("GCD(16, 64, 96, 44) => ", getGCDofList([]int{16, 64, 96, 44}))
}
