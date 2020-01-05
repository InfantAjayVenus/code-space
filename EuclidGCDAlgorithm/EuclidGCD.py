def getGCD(firstNum, secondNum):

    if(firstNum < secondNum):
        firstNum, secondNum = secondNum, firstNum

    if secondNum > 0:
        return getGCD(secondNum, firstNum%secondNum)
    else:
        return firstNum


print("GCD(6,4) => {}".format(getGCD(6,4)))
print("GCD(4,6) => {}".format(getGCD(4,6)))
print("GCD(2024, 125) => {}".format(getGCD(2024, 125)))