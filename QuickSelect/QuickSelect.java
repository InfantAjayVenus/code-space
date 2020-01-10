class QuickSelect {
    
    private int[] list;

    QuickSelect(int[]inputList) {
        this.list = inputList;
    }

    @SuppressWarnings("unused")
    private void printArray(int[] array, String message) {
        System.out.print(message + " => ");
        for (int num : array) {
            System.out.print("\t" + num);
        }
        System.out.println();
    }

    @SuppressWarnings("unused")
    private void printArray(int[] array, int rangeStart, int rangeEnd, String message) {
        System.out.print(message + " => ");
        for (int i = rangeStart; i < rangeEnd; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.println();
    }

    private int sortedPartition(int rangeStart, int rangeEnd, int pivotPosition) {
        int pivotElement = this.list[pivotPosition];
        int forwardIndex = rangeStart;
        int backwardIndex = rangeEnd;

        while(forwardIndex < backwardIndex) {
            while (this.list[forwardIndex] < pivotElement){
                forwardIndex++;
            }

            while (this.list[backwardIndex] > pivotElement){
                backwardIndex--;
            }

            if(forwardIndex < backwardIndex) {
                int temp = this.list[forwardIndex];
                this.list[forwardIndex] = this.list[backwardIndex];
                this.list[backwardIndex] = temp;
            }
        }

        return forwardIndex ;
    }

    private int getKthSmallestValue(int k, int rangeStart, int rangeEnd) {
        
        int pivotPosition = sortedPartition(rangeStart, rangeEnd, rangeStart);

        if ( pivotPosition == k-1) {
            return this.list[pivotPosition];
        }else if (pivotPosition > k-1) {
            return getKthSmallestValue(k, rangeStart, pivotPosition - 1);
        }else{
            return getKthSmallestValue(k , pivotPosition + 1, rangeEnd);
        }
    }

    public int getKthSmallestValue(int k) {
        try {
            if(k < 1 || k > this.list.length){
                
                throw(new Exception("Key Term out of bounds"));
            } else {

                return getKthSmallestValue(k, 0, this.list.length - 1);
            }
            
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return -99999;
        }
    }



    public static void main(String[] args) {
        
        QuickSelect selector = new QuickSelect(new int[]{2, 6, 3, 9, 1, 5});
        
        System.out.println("1st smallest(2, 6, 3, 9, 1, 5): "+selector.getKthSmallestValue(1));
        System.out.println("4th smallest(2, 6, 3, 9, 1, 5): "+selector.getKthSmallestValue(4));
        System.out.println("last smallest(2, 6, 3, 9, 1, 5): "+selector.getKthSmallestValue(6));
        System.out.println("0th smallest(2, 6, 3, 9, 1, 5): "+selector.getKthSmallestValue(0));
        System.out.println("7th smallest(2, 6, 3, 9, 1, 5): "+selector.getKthSmallestValue(7));
    }
}
