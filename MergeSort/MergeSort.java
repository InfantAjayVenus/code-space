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
        int[] mergedList = new int[rangeEnd - rangeStart + 1];
        int index = 0, firstListIndex = rangeStart, secondListIndex = rangeMid + 1;

        while (index < mergedList.length) {

            if (firstListIndex > rangeMid) {
                for (int i = secondListIndex; i <= rangeEnd; i++) {
                    mergedList[index++] = this.list[i];
                }
                break;
            }

            if (secondListIndex > rangeEnd) {
                for (int i = firstListIndex; i <= rangeMid; i++) {
                    mergedList[index++] = this.list[i];
                }
                break;
            }

            if (this.list[firstListIndex] < this.list[secondListIndex]) {
                mergedList[index] = this.list[firstListIndex++];
            } else {
                mergedList[index] = this.list[secondListIndex++];
            }

            index++;
        }

        index = rangeStart;

        for (int num : mergedList) {
            this.list[index++] = num;
        }

    }

    private void sort(int rangeStart, int rangeEnd) {
        if (rangeStart < rangeEnd) {
            int rangeMid = (rangeStart + rangeEnd) / 2;

            this.sort(rangeStart, rangeMid);
            this.sort(rangeMid + 1, rangeEnd);
            this.sortedMerge(rangeStart, rangeMid, rangeEnd);
        }
    }

    public int[] sort(int[] inputList) {
        this.list = inputList;
        this.sort(0, inputList.length - 1);
        return this.list;
    }

    public static void main(String[] args) {
        MergeSort sortingObj = new MergeSort();
        sortingObj.printArray(sortingObj.sort(new int[] { 2, 6, 3, 9, 1, 5 }), "sort(2, 6, 3, 9, 1, 5)");
        sortingObj.printArray(sortingObj.sort(new int[] { 2, 6, 3, 9, 1 }), "sort(2, 6, 3, 9, 1)");
    }
}