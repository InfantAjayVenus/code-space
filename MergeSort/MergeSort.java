public class MergeSort {

    private int[] list;

    public void printArray(int[] array, String message) {
        System.out.print(message + " => ");
        for (int num : array) {
            System.out.print("\t" + num);
        }
        System.out.println();
    }

    public void printArray(int[] array, int rangeStart, int rangeEnd, String message) {
        System.out.print(message + " => ");
        for (int i = rangeStart; i < rangeEnd; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.println();
    }

    private void sortedMerge(int rangeStart, int rangeMid, int rangeEnd) {
        int firstListIndex = rangeStart, secondListIndex = rangeMid + 1, index = rangeStart;

        while(index < rangeEnd) {
            if(this.list[firstListIndex] < this.list[secondListIndex]) {
                int temp = this.list[index];
                this.list[index++] = list[firstListIndex];
                list[firstListIndex++] = temp;
            }else{
                int temp = this.list[index];
                this.list[index++] = list[secondListIndex];
                list[secondListIndex++] = temp;
            }
        }
    }

    private void sort(int rangeStart, int rangeEnd) {
        if (rangeEnd < rangeStart){
            int rangeMid = (rangeStart + rangeEnd)/2;

            this.sort(rangeStart, rangeMid);
            this.sort(rangeMid+1, rangeEnd);
            this.sortedMerge(rangeStart, rangeMid, rangeEnd);
        }
    }

    public int[] sort(int[] inputList) {
        this.list = inputList;
        this.sort(0, inputList.length);
        return this.list;
    }

    public static void main(String[] args) {
        MergeSort sortingObj = new MergeSort();
        sortingObj.printArray(sortingObj.sort(new int[] {2, 6, 3, 9, 1, 5}), "sort(2, 6, 3, 9, 1, 5)");
        // MergeSort.printArray(MergeSort.sort(new int[] { 2, 6, 3, 9, 1, 5 }), "sort(2, 6, 3, 9, 1, 5)");
        // System.out.println("sort(2, 6, 3, 9, 1) => " + MergeSort.sort(new int[] { 2,
        // 6, 3, 9, 1 }));
    }
}