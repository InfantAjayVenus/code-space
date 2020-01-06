const sortedMerge = (firstList, secondList) => {
  let sortedList = [],
    firstListIndex = 0,
    secondListIndex = 0;

  while (sortedList.length !== (firstList.length + secondList.length)) {
    if (firstList[firstListIndex] < secondList[secondListIndex]) {
      sortedList.push(firstList[firstListIndex++]);
    } else {
      sortedList.push(secondList[secondListIndex++]);
    }

    if (firstListIndex === firstList.length) {
      sortedList = sortedList.concat(secondList.slice(secondListIndex, secondList.length));
    }

    if (secondListIndex === secondList.length) {
      sortedList = sortedList.concat(firstList.slice(firstListIndex, firstList.length));
    }

  }
  return sortedList;
};

const sort = inputList => {
  if (inputList.length === 1) {
    return inputList;
  } else if (inputList.length > 1) {

    const mid = inputList.length / 2;
    const firstHalf = inputList.slice(0, mid);
    const secondHalf = inputList.slice(mid, inputList.length);

    return sortedMerge(sort(firstHalf), sort(secondHalf));
  }
};

console.log(`sort(2, 6, 3, 9, 1, 5) => ${sort([2, 6, 3, 9, 1, 5])}`);
console.log(`sort(2, 6, 3, 9, 1) => ${sort([2, 6, 3, 9, 1])}`);
