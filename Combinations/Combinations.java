package Combinations;

class Combinations {
    public static void main(String[] args) {
        int[] testList = {1, 2, 3, 4, 5};
        int[][] combinationsList = getCombinations(testList, 3);

        for(int[] list: combinationsList) {
            for(int listItem: list) {
                System.out.print(listItem + "\t");
            }
            System.out.println();
        }
    }

    static int[][] getCombinations(int[] freeList, int length) {
        return getCombinations(freeList, length, 0);
    }

    static int[][] getCombinations(int[] freeList, int length, int startIndex) {

        if(startIndex == freeList.length - 1) {
            int[] currentList = {freeList[startIndex]};
        }

        int[] currentElement = {freeList[startIndex]};

        int[][] partialList = getCombinations(freeList, length, startIndex + 1);

        for(int i = 0; i < partialList.length; i++) {
            int[] partialListItem = partialList[i];
            if(partialListItem.length == length) {
                continue;
            }

            int[] updatedPartialList = new int[currentElement.length + partialListItem.length];
            System.arraycopy(currentElement, 0, updatedPartialList, 0, currentElement.length);
            System.arraycopy(partialListItem, 0, updatedPartialList, currentElement.length, partialListItem.length);
            partialList[i] = updatedPartialList;
        }

        return partialList;

    }
}