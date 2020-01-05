const sort = (inputList) => {
    for (let index = 0; index < inputList.length; index++) {
        let element = inputList[index];
        let elementIndex = index;
        for(let i = index; i < inputList.length; i++){
            if(element > inputList[i]){
                element = inputList[i];
                elementIndex = i;
            }
        }

        [inputList[index], inputList[elementIndex]] = [inputList[elementIndex], inputList[index]];
    }
    return inputList;
}

console.log(`sort(2, 6, 3, 9, 1, 5) => ${sort([2,6,3,9,1,5])}`);
