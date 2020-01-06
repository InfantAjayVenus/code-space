def sortedMerge(firstList, secondList):
    sortedList = []
    firstListIndex = secondListIndex = 0

    while len(sortedList) < (len(firstList) + len(secondList)):
        if firstList[firstListIndex] < secondList[secondListIndex]:
            sortedList.append(firstList[firstListIndex])
            firstListIndex = firstListIndex + 1
        else:
            sortedList.append(secondList[secondListIndex])
            secondListIndex = secondListIndex + 1

        if firstListIndex == len(firstList):
            sortedList = sortedList + secondList[secondListIndex : len(secondList)]

        if secondListIndex == len(secondList):
            sortedList = sortedList + firstList[firstListIndex : len(firstList)]

    return sortedList


def sort(inputList):
    inputLength = len(inputList)

    if inputLength > 1:
        return sortedMerge(
            sort(inputList[0 : int(inputLength / 2)]),
            sort(inputList[int(inputLength / 2) : inputLength]),
        )
    else:
        return inputList


print("sort(2, 6, 3, 9, 1, 5) => {}".format(sort([2, 6, 3, 9, 1, 5])))
print("sort(2, 6, 3, 9, 1) => {}".format(sort([2, 6, 3, 9, 1])))
