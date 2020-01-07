const sortedInsert = (inputList, pivotElement) => ([
    inputList.filter(listItem => listItem < pivotElement),
    pivotElement,
    inputList.filter(listItem => listItem > pivotElement)
]);

const sort = (inputList) => {
    if (inputList.length > 1) {

        console.log(`pivot: ${inputList[inputList.length/2]}`);
        
        const [firstList, pivotElement, secondList] = sortedInsert(inputList, inputList[inputList.length/2]);

        console.log(`FirstList: ${firstList}; SecondList: ${secondList}`);
        
        return [
            ...(firstList!==undefined?[...sort(firstList)]:[]),
            pivotElement,
            ...(secondList!==undefined?[...sort(secondList)]:[]),
        ];

    } else {
        return inputList;
    }

}

console.log(`sort(2, 6, 3, 9, 1, 5) => ${sort([2, 6, 3, 9, 1, 5])}`);
console.log(`sort(2, 6, 3, 9, 1) => ${sort([2, 6, 3, 9, 1])}`);