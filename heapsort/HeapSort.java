class HeapSort {
    int[] list;

    public int[] sort(int[]inputList) {
        this.list = inputList;
        for(int i = (this.list.length / 2) - 1; i >= 0; i--) {
            maxHeapify(i, this.list.length);
        }


        for(int i = this.list.length - 1; i>=0; i--) {
            int temp = this.list[0];
            this.list[0] = this.list[i];
            this.list[i] = temp;
            maxHeapify(0, i);
        }
        return this.list;
    }

    private void maxHeapify(int currentNodeIndex, int length) {
        int largestIndex = currentNodeIndex;
        int rightChildIndex = HeapSort.getRightChildIndex(currentNodeIndex);
        int leftChildIndex = HeapSort.getLeftChildIndex(currentNodeIndex);

        if(leftChildIndex < length && this.list[leftChildIndex] > this.list[largestIndex]){
            largestIndex = leftChildIndex;
        }

        if(rightChildIndex < length && this.list[rightChildIndex] > this.list[largestIndex]){
            largestIndex = rightChildIndex;
        }

        if(largestIndex != currentNodeIndex) {
            int temp = this.list[largestIndex];
            this.list[largestIndex] = this.list[currentNodeIndex];
            this.list[currentNodeIndex] = temp;

            this.maxHeapify(largestIndex, length);
        }
    }

    private static int getLeftChildIndex(int currentIndex) {
        return (2*currentIndex)+1;
    }

    private static int getRightChildIndex(int currentIndex) {
        return (2*currentIndex)+2;
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
    
    public static void printHeap(int[] heapArray, String message){
        System.out.println(message);
        printHeap(heapArray, 0, "");
    }

    public static void printHeap(int[] heapArray, int currentNodeIndex, String preceed){
        if(currentNodeIndex < heapArray.length){
            System.out.println(preceed+heapArray[currentNodeIndex]);
            printHeap(heapArray, getLeftChildIndex(currentNodeIndex), preceed+"--");
            printHeap(heapArray, getRightChildIndex(currentNodeIndex), preceed+"--");
        }
    }

    public static void main(String[] args) {
        HeapSort sortingObj = new HeapSort();
        HeapSort.printArray(sortingObj.sort(new int[] { 2, 6, 3, 9, 1, 5 }), "sort(2, 6, 3, 9, 1, 5)");
        HeapSort.printArray(sortingObj.sort(new int[] { 2, 6, 3, 9, 1 }), "sort(2, 6, 3, 9, 1)");
    }
}