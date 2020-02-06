# Heap Sort
A Heap is a complete binary tree that has a property where a parent node is always greater(max-heap) or smaller(min-heap) to both of its children.

Heap sort uses this property to sort the list with a O(n Log(n)) worst case complexity.

## Algorithm
```
Heap Sort:
    buildMaxHeap(list) /*Ensures first elements as largest*/

    swap(list[first], list[last]) /* inserted largest element at last*/
    buildMaxHeap(list[first -> (last-1)]) /*Build heap of list without last element*/

BuildMaxHeap:
    For element in list[mid -> first],
        heapify(list, element as root)

Heapify:
    If root is smaller than children,
            swap corresponding child
            heapify(list, swappedChild as root)
```
