const sortedMerge = (firstList, secondList) => {
  const sortedList = [];
  let firstListIndex = 0,
    secondListIndex = 0;

  while (
    firstListIndex !== firstList.length ||
    secondListIndex !== secondList.length
  ) {
    if (firstList[firstListIndex] < secondList[secondListIndex]) {
      sortedList.push(firstList[firstListIndex++]);
    } else {
      sortedList.push(secondList[secondListIndex++]);
    }
  }

  sortedList.push(firstList.slice(firstListIndex, firstList.length));
  sortedList.push(secondList.slice(secondListIndex, secondList.length));

  return sortedList;
};

const sort = inputList => {
  if (inputList.length === 1) {
    return inputList;
  } else if (inputList.length > 1) {
    const mid = inputList.length / 2;
    const firstHalf = inputList.slice(mid);
    const secondHalf = inputList.slice(mid, inputList.length);
    
    return sortedMerge(sort(firstHalf), sort(secondHalf));
  }
};

console.log(`sort(2, 6, 3, 9, 1, 5) => ${sort([2, 6, 3, 9, 1, 5])}`);
