class QuickSort {
    private int[] list;

    private int sortedInsert(int rangeStart, int rangeEnd, int pivotPosition) {

        int smallIndex = rangeStart, largeIndex = rangeEnd, pivotElement = this.list[pivotPosition];
        while (smallIndex < largeIndex) {
            while (this.list[smallIndex] < pivotElement) {
                smallIndex++;
            }
            while (this.list[largeIndex] > pivotElement) {
                largeIndex--;
            }

            if (smallIndex < largeIndex) {
                int temp = this.list[smallIndex];
                this.list[smallIndex] = this.list[largeIndex];
                this.list[largeIndex] = temp;
            }

        }

        return smallIndex;
    }

    private void sort(int rangeStart, int rangeEnd) {
        if (rangeEnd - rangeStart > 1) {
            int updatedPivotPosition = this.sortedInsert(rangeStart, rangeEnd, rangeStart);
            this.sort(rangeStart, updatedPivotPosition);
            this.sort(updatedPivotPosition + 1, rangeEnd);
        }
    }

    public int[] sort(int[] inputList) {
        this.list = inputList;
        this.sort(0, inputList.length - 1);
        return this.list;
    }

    public static void printArray(int[] array, String message) {
        System.out.print(message + " => ");
        for (int num : array) {
            System.out.print("\t" + num);
        }
        System.out.println();
    }

    public static void printArray(int[] array, int rangeStart, int rangeEnd, String message) {
        System.out.print(message + " => ");
        for (int i = rangeStart; i < rangeEnd; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort sortingObj = new QuickSort();
        QuickSort.printArray(sortingObj.sort(new int[] { 2, 6, 3, 9, 1, 5 }), "sort(2, 6, 3, 9, 1, 5)");
        QuickSort.printArray(sortingObj.sort(new int[] { 2, 6, 3, 9, 1 }), "sort(2, 6, 3, 9, 1)");
    }
}