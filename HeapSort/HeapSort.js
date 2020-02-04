const sort = (inputList) => {
    const heap = buildMaxHeap(inputList);

    for(let i = heap.length - 1; i >= 0; i--) {
        [inputList[0], inputList[i]] = [inputList[i], inputList[0]];
        inputList = maxHeapify(inputList, 0, i);
    }

    return inputList;
}

const buildMaxHeap = (inputList) => {
    for( let i = inputList.length / 2; i >= 0; i--) {
        inputList = maxHeapify(inputList, i);
    }

    return inputList;
}

const maxHeapify = (inputList, rootIndex, length=inputList.length) => {
    let maxIndex = rootIndex;
    const leftChildIndex = getLeftChildIndex(rootIndex);
    const rightChildIndex = getRightChildIndex(rootIndex);

    if( (leftChildIndex < length) && (inputList[rootIndex] < inputList[leftChildIndex]) ) {
        maxIndex = leftChildIndex;
    }

    if( (rightChildIndex < length) && (inputList[rootIndex] < inputList[rightChildIndex]) ) {
        maxIndex = rightChildIndex;
    }

    if(maxIndex !== rootIndex) {
        [inputList[rootIndex], inputList[maxIndex]] = [inputList[maxIndex], inputList[rootIndex]];
        maxHeapify(inputList, maxIndex, length);
    }

    return inputList;
}

const getLeftChildIndex = parentIndex => parentIndex * 2 + 1;

const getRightChildIndex = parentIndex => parentIndex * 2 + 2;

console.log(`sort(2, 6, 3, 9, 1, 5) => ${sort([2, 6, 3, 9, 1, 5])}`);
