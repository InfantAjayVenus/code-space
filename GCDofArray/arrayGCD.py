def getGCD(firstNum, secondNum):
    if firstNum < secondNum:
        firstNum, secondNum = secondNum, firstNum

    if secondNum > 0:
        return getGCD(secondNum, firstNum%secondNum)
    else:
        return firstNum

def getGCDofList(numberList):
    result = numberList.pop()
    for i in numberList:
        result = getGCD(i, result)

    return result

print("GCD(24, 62, 194) => {}".format(getGCDofList([24, 62, 194])))
print("GCD(16, 64, 96, 44) => {}".format(getGCDofList([16, 64, 96, 44])))