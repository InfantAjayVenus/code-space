getLeftChildPosition = lambda currentPosition : 2 * currentPosition + 1
getRightChildPosition = lambda currentPosition: 2 * currentPosition + 2

def maxHeapify(rootIndex, inputList):
    parent = rootIndex
    leftChildPosition = getLeftChildPosition(rootIndex)
    rightChildPosition = getRightChildPosition(rootIndex)

    if (leftChildPosition < len(inputList)) and (inputList[parent] < inputList[leftChildPosition]):
        parent = leftChildPosition

    if (rightChildPosition < len(inputList)) and (inputList[parent] < inputList[rightChildPosition]):
        parent = rightChildPosition

    if parent != rootIndex :
        inputList[parent], inputList[rootIndex] = inputList[rootIndex], inputList[parent]
        maxHeapify(parent, inputList)

def buildMaxHeap(inputList):
    for i in range(len(inputList)//2, -1, -1):
        maxHeapify(i, inputList)
    return inputList

def sort(inputList):
    heap = buildMaxHeap(inputList)
    for i in range(len(heap) - 1, -1, -1):
        print("Before swap => {}".format(heap))
        heap[0], heap[i] = heap[i], heap[0]
        print("After swap => {}".format(heap))
        maxHeapify(0, heap[:i])
        print("After Heapified => {}".format(heap))

    return heap

print("sort(2, 6, 3, 9, 1, 5) => {}".format(sort([2, 6, 3, 9, 1, 5])))
# print("sort(2, 6, 3, 9, 1) => {}".format(sort([2, 6, 3, 9, 1])))