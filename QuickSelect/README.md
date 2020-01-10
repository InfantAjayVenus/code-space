# Quick Select
Quickselect is a selection algorithm to find the k-th smallest element in an unordered list. It is similar to the quick sort algorithm.

## Algorithm
```
QuickSelect
    Choose a Pivot Element and call partition(inputList, pivot)
    If
        updated pivot position is in kth position,
            return inputList[pivot position]
    Else if
        updated pivot position > k,
            call QuickSelect for list values before pivot position
    Else
        call QuickSelect for list values after pivot position



Partition
    Till forwardIndex < backwardIndex
        increase forwardIndex till inputList[forwardIndex] < pivotElement
        decrease backwardIndex till inputList[backwardIndex] > pivotElement

        If,
            forwardIndex < backwardIndex
            swap(inputList[forwardIndex], inputList[backwardIndex])

    return updated pivotElement position which is forwardIndex
```