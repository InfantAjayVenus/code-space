class InsertionSort {
    static int[] sort(int[] inputList) {
        for(int index = 0; index < inputList.length; index++){
            int element = inputList[index];
            int elementIndex = index;
            for(int i = index; i < inputList.length; i++) {
                if(element > inputList[i]) {
                    element = inputList[i];
                    elementIndex = i;
                }
            }

            inputList[elementIndex] = inputList[index];
            inputList[index] = element;
        }

        return inputList;
    }

    public static void main(String[] args) {
        int[] sortedList =  sort(new int[]{2, 6, 3, 9, 1, 5});
        System.out.print("sort(2, 6, 3, 9, 1, 5) => ");
        for(int num: sortedList){
            System.out.print("\t"+num);
        }
        System.out.println();
    }
}