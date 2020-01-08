const sortedInsert = (inputList, pivotElement) => ([
    inputList.filter(listItem => listItem < pivotElement),
    pivotElement,
    inputList.filter(listItem => listItem > pivotElement)
]);

const sort = (inputList) => {

    if (inputList.length > 1) {

        const [firstList, pivotElement, secondList] = sortedInsert(inputList, inputList[0]);

        return [
            ...(firstList ? [...sort(firstList)] : []),
            pivotElement,
            ...(secondList ? [...sort(secondList)] : [])
        ];

    } else {
        return inputList;
    }

}

console.log(`sort(2, 6, 3, 9, 1, 5) => ${sort([2, 6, 3, 9, 1, 5])}`);
console.log(`sort(2, 6, 3, 9, 1) => ${sort([2, 6, 3, 9, 1])}`);