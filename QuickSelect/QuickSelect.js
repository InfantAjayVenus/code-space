const sortedPartition = (inputList, pivotElement) => ({
    firstList: inputList.filter(listItem => listItem < pivotElement),
    pivotElement,
    secondList: inputList.filter(listItem => listItem > pivotElement)
})

const getKthSmallest = (inputList, k) => {
    
    if (k < 1 || k > inputList.length) {
        return Error("Term k must be within range of input list length");
    }
    const { firstList, pivotElement, secondList } = sortedPartition(inputList, inputList[0]);
    
    if (firstList.length === k - 1) {
        return pivotElement;
    } else if (firstList.length >= k) {
        return getKthSmallest(firstList, k);
    } else {
        return getKthSmallest(secondList, k - firstList.length - 1);
    }

}

console.log(`1st Smallest(2, 6, 3, 9, 1, 5) => ${getKthSmallest([2, 6, 3, 9, 1, 5], 1)}`);
console.log(`4th Smallest(2, 6, 3, 9, 1, 5) => ${getKthSmallest([2, 6, 3, 9, 1, 5], 4)}`);
console.log(`last Smallest(2, 6, 3, 9, 1, 5) => ${getKthSmallest([2, 6, 3, 9, 1, 5], 6)}`);
console.log(`0th Smallest(2, 6, 3, 9, 1, 5) => ${getKthSmallest([2, 6, 3, 9, 1, 5], 0)}`);
console.log(`7th Smallest(2, 6, 3, 9, 1, 5) => ${getKthSmallest([2, 6, 3, 9, 1, 5], 7)}`);
