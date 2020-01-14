class HeapSort {
    int[] list;

    public int[] sort(int[]inputList) {
        this.list = inputList;
        for(int i = (this.list.length / 2) - 1; i >= 0; i--) {
            heapifyDownward(0, i);
        }

        for(int i = this.list.length - 1; i>=0; i--) {
            int temp = this.list[0];
            this.list[0] = this.list[i];
            this.list[i] = temp;

            heapifyUpward(i);
        }
        return this.list;
    }

    @SuppressWarnings("unused")
    private void heapify(int currentNodeIndex) {
        int smallestIndex = currentNodeIndex;
        int rightChildIndex = this.getRightChildIndex(currentNodeIndex);
        int leftChildIndex = this.getLeftChildIndex(currentNodeIndex);

        if(leftChildIndex < this.list.length && this.list[leftChildIndex] < this.list[smallestIndex]){
            smallestIndex = leftChildIndex;
        }

        if(rightChildIndex < this.list.length && this.list[rightChildIndex] < this.list[smallestIndex]){
            smallestIndex = rightChildIndex;
        }

        if(smallestIndex != currentNodeIndex) {
            int temp = this.list[smallestIndex];
            this.list[smallestIndex] = this.list[currentNodeIndex];
            this.list[currentNodeIndex] = temp;

            this.heapify(smallestIndex);
        }

    }

    private void heapifyUpward(int currentNodeIndex) {
        int smallestIndex = currentNodeIndex;
        int parentNodeIndex = this.getParentIndex(currentNodeIndex);

        if(currentNodeIndex > 0 && this.list[parentNodeIndex] < this.list[smallestIndex]) {
            smallestIndex = parentNodeIndex;
        }

        if(smallestIndex != currentNodeIndex) {
            int temp = this.list[currentNodeIndex];
            this.list[currentNodeIndex] = this.list[smallestIndex];
            this.list[smallestIndex] = temp;

            this.heapifyUpward(smallestIndex);
        }
        
    }

    private void heapifyDownward(int currentNodeIndex, int length) {
        int smallestIndex = currentNodeIndex;
        int rightChildIndex = this.getRightChildIndex(currentNodeIndex);
        int leftChildIndex = this.getLeftChildIndex(currentNodeIndex);

        if(leftChildIndex < length && this.list[leftChildIndex] < this.list[smallestIndex]){
            smallestIndex = leftChildIndex;
        }

        if(rightChildIndex < length && this.list[rightChildIndex] < this.list[smallestIndex]){
            smallestIndex = rightChildIndex;
        }

        if(smallestIndex != currentNodeIndex) {
            int temp = this.list[smallestIndex];
            this.list[smallestIndex] = this.list[currentNodeIndex];
            this.list[currentNodeIndex] = temp;

            this.heapifyDownward(smallestIndex, length);
        }
    }

    @SuppressWarnings("unused")
    private int getParentIndex(int currentIndex) {
        return (currentIndex-1)/2;
    }

    @SuppressWarnings("unused")
    private int getLeftChildIndex(int currentIndex) {
        return (2*currentIndex)+1;
    }

    @SuppressWarnings("unused")
    private int getRightChildIndex(int currentIndex) {
        return (2*currentIndex)+2;
    }

    @SuppressWarnings("unused")
    public static void printArray(int[] array, String message) {
        System.out.print(message + " => ");
        for (int num : array) {
            System.out.print("\t" + num);
        }
        System.out.println();
    }

    @SuppressWarnings("unused")
    public static void printArray(int[] array, int rangeStart, int rangeEnd, String message) {
        System.out.print(message + " => ");
        for (int i = rangeStart; i < rangeEnd; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        HeapSort sortingObj = new HeapSort();
        HeapSort.printArray(sortingObj.sort(new int[] { 2, 6, 3, 9, 1, 5 }), "sort(2, 6, 3, 9, 1, 5)");
        // HeapSort.printArray(sortingObj.sort(new int[] { 2, 6, 3, 9, 1 }), "sort(2, 6, 3, 9, 1)");
    }
}