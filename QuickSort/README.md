# Quick Sort
QuickSort is a Divide and Conquer algorithm. It selects an element as pivot and partitions the given array around the selected pivot.

## Algorithm
```
Quick Sort:
    If low < high
        /* pi is partitioning index, arr[pi] is now at right place */
        pi = partition(array, low, high);

        quickSort(array, low, pi - 1);  // partition before pivot
        quickSort(array, pi + 1, high); // partition after pivot
```

```
Partition:
    pivotElement = array[low] or array[high] or array[mid]
    forwardIndex = low // Array start
    backwardIndex = high // Array End

    Till forwardIndex < backwardIndex
        increase forwardIndex  till array[forwardIndex] < pivot
        decrease backwardIndex till array[backwardIndex] > pivot

        If forwardIndex < backwardIndex
            swap(array[forwardIndex], array[backwardIndex])

    forwardIndex is the partition index, seperating the array.
```