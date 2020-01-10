def sortedPartition(inputList, pivotPosition) :
    forwardIndex = 0
    backwardIndex = len(inputList) - 1
    pivotElement = inputList[pivotPosition]
    while forwardIndex < backwardIndex :
        while inputList[forwardIndex] < pivotElement :
            forwardIndex = forwardIndex + 1

        while inputList[backwardIndex] > pivotElement :
            backwardIndex = backwardIndex - 1

        if forwardIndex < backwardIndex :
            inputList[forwardIndex], inputList[backwardIndex] = inputList[backwardIndex], inputList[forwardIndex]

    return forwardIndex


def getKthSmallest(inputList, k):
    if k < 1 or k > len(inputList):
        return "Key Term exceeds list range"
 
    pivotPosition = sortedPartition(inputList, 0)

    if pivotPosition == k - 1 :
        return inputList[pivotPosition]
    elif pivotPosition > k - 1:
        return getKthSmallest(inputList[:pivotPosition], k)
    else:
        return getKthSmallest(inputList[pivotPosition+1:], k - pivotPosition - 1 )

print("1st Smallest(2, 6, 3, 9, 1, 5) => {}".format(getKthSmallest([2, 6, 3, 9, 1, 5], 1)))
print("4th Smallest(2, 6, 3, 9, 1, 5) => {}".format(getKthSmallest([2, 6, 3, 9, 1, 5], 4)))
print("last Smallest(2, 6, 3, 9, 1, 5) => {}".format(getKthSmallest([2, 6, 3, 9, 1, 5], 6)))
print("0th Smallest(2, 6, 3, 9, 1, 5) => {}".format(getKthSmallest([2, 6, 3, 9, 1, 5], 0)))
print("7th Smallest(2, 6, 3, 9, 1, 5) => {}".format(getKthSmallest([2, 6, 3, 9, 1, 5], 7)))
