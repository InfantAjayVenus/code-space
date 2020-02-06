def sort(inputList):
    heap = buildMaxHeap(inputList)
    
    for i in range(len(heap) - 1, -1, -1):
        heap[0], heap[i] = heap[i], heap[0]
        maxHeapify(heap, 0, i)

    return heap

def buildMaxHeap(inputList):
    for i in range(len(inputList)//2, -1, -1):
        maxHeapify(inputList, i)
    return inputList

def maxHeapify(inputList, rootIndex, range=None):
    range = range if range != None else len(inputList)-1
    maxIndex = rootIndex
    leftChildPosition = getLeftChildPosition(rootIndex)
    rightChildPosition = getRightChildPosition(rootIndex)

    if (leftChildPosition < range) and (inputList[maxIndex] < inputList[leftChildPosition]):
        maxIndex = leftChildPosition

    if (rightChildPosition < range) and (inputList[maxIndex] < inputList[rightChildPosition]):
        maxIndex = rightChildPosition

    if maxIndex != rootIndex :
        inputList[maxIndex], inputList[rootIndex] = inputList[rootIndex], inputList[maxIndex]
        maxHeapify(inputList, maxIndex, range)

getLeftChildPosition = lambda currentPosition : 2 * currentPosition + 1
getRightChildPosition = lambda currentPosition: 2 * currentPosition + 2

print("sort(2, 6, 3, 9, 1, 5) => {}".format(sort([2, 6, 3, 9, 1, 5])))
print("sort(2, 6, 3, 9, 1) => {}".format(sort([2, 6, 3, 9, 1])))