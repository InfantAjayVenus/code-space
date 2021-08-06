const getCombinations = (inputList) => {
  if(inputList.length === 0) {
    return [];
  }  


  const firstElement = inputList.shift();
  const combinations = [firstElement, ...getCombinations([...inputList]), ...(getCombinations([...inputList]).map(item => firstElement+ item))];

  return combinations;
}

const testCombinations = (inputString) => console.log(`combinations(${inputString}) => ${JSON.stringify(getCombinations(inputString.split('')))}`);


testCombinations('')
testCombinations('a')
testCombinations('ab')
testCombinations('abc')
