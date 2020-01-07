def sortedInsert(inputList, pivotPosition):
    index = -1
    pivotElement = inputList[pivotPosition]

    print("InputList: ", inputList, "PivotElement", pivotElement)

    for i in range(len(inputList)):
        if inputList[i] < pivotElement:
            index = index + 1
            print("swapping ({},{}) ".format(inputList[i], inputList[index]))
            inputList[i], inputList[index] = inputList[index], inputList[i]

        if inputList[i] == pivotElement:
            pivotPosition = i

    index = index + 1
    inputList[index], inputList[pivotPosition] = inputList[pivotPosition],inputList[index]

    print("insertedList", inputList)
    return inputList, index


def sort(inputList):

    if len(inputList) > 1:
        inputList, pivotPosition = sortedInsert(inputList, 0)
        return (
            sort(inputList[:pivotPosition])
            + [inputList[pivotPosition]]
            + sort(inputList[pivotPosition + 1 :])
        )
    else:
        return inputList


print("sort(2, 6, 3, 9, 1, 5) => {}".format(sort([2, 6, 3, 9, 1, 5])))
# print("sort(2, 6, 3, 9, 1) => {}".format(sort([2, 6, 3, 9, 1])))
