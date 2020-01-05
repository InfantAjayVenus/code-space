const getGCD = (firstNum, secondNum) => {
    if(firstNum < secondNum) {
        [firstNum, secondNum] = [secondNum, firstNum];
    }

    if(secondNum > 0){
        return getGCD(secondNum, firstNum%secondNum);
    } else {
        return firstNum;
    }
}

console.log(`GCD(6,4) => ${getGCD(6, 4)}`);
console.log(`GCD(4,6) => ${getGCD(4, 6)}`);
console.log(`GCD(2024,125) => ${getGCD(2024, 125)}`);
