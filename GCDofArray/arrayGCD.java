class ArrayGCD {
    
    static int getGCD(int firstNum, int secondNum) {
        if(firstNum < secondNum) {
            int temp = firstNum;
            firstNum = secondNum;
            secondNum = firstNum;
        }

        if(secondNum > 0) {
            return getGCD(secondNum, firstNum % secondNum);
        }else{
            return firstNum;
        }
    }

    static int getGCDofArray(int[] numberList){
        int result = numberList[0];

        for(int i = 1; i < numberList.length; i++){
            result = ArrayGCD.getGCD(numberList[i], result);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("GCD(24, 62, 194) => "+ ArrayGCD.getGCDofArray(new int[]{24, 62, 194}));
        System.out.println("GCD(16, 64, 96, 44) => "+ ArrayGCD.getGCDofArray(new int[]{16, 64, 96, 44}));
    }
}