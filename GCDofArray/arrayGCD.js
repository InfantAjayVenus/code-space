const getGCD = (firstNum, secondNum) => {
    if(firstNum < secondNum) {
        [firstNum, secondNum] = [secondNum, firstNum];
    }

    if(secondNum > 0){
        return getGCD(secondNum, firstNum % secondNum);
    }else{
        return firstNum;
    }
}

const getGCDofList = (numberList) => {
    return numberList.reduce(getGCD);
}

console.log(`GCD(24, 62, 194) => ${getGCDofList([24, 62, 194])}`)
console.log(`GCD(16, 64, 96, 44) => ${getGCDofList([16, 64, 96, 44])}`)