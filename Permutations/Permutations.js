const getPermutations = (inputList) => {
  if(inputList.length === 0) {
    return [''];
  }

  const firstElement = inputList.shift();
  const permutationWithoutFirst = getPermutations([...inputList]);

  const permutationsList = [];
  
  permutationWithoutFirst.forEach(element => {
    for(let i = 0; i <= element.length; i++) {
      permutationsList.push(`${element.slice(0,i)}${firstElement}${element.slice(i)}`)
    }
  })

  return permutationsList;
}

const testPermutations = (inputString) => {
  console.log(`Permutations(${inputString}) => ${JSON.stringify(getPermutations(inputString.split('')))}`)
}

testPermutations('abc');
testPermutations('abcd');
