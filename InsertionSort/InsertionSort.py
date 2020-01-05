def sort(inputList):
    for index in range(len(inputList)):
        element = inputList[index]
        elementIndex = index
        
        for i in range(index, len(inputList)):
            if element > inputList[i]:
                element = inputList[i]
                elementIndex = i

        inputList[index], inputList[elementIndex] = inputList[elementIndex], inputList[index]

    return inputList

print("sort(2, 6, 3, 9, 1, 5) => {}".format(sort([2, 6, 3, 9, 1, 5])))