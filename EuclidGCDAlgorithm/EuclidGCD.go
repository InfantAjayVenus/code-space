package main

import "fmt"

func swap(firstNum int, secondNum int) (int, int) {
	return secondNum, firstNum
}

func getGCD(firstNum int, secondNum int) int {
	if firstNum < secondNum {
		firstNum, secondNum = swap(firstNum, secondNum)
	}

	if secondNum > 0 {
		return getGCD(secondNum, firstNum%secondNum)
	} else {
		return firstNum
	}
}

func main() {
	fmt.Println("GCD(6, 4) => ", getGCD(6, 4))
	fmt.Println("GCD(4, 6) => ", getGCD(4, 6))
	fmt.Println("GCD(2024, 125) => ", getGCD(2024, 125))
}
