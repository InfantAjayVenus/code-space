/*
    working => 4,9,3,8,5
    arr-> 4,9,3,8,5 low -> 0, high -> 4 i.e(5)
    pivot -> 5 -> checking 4 < 5 so swap (4,4)
                  checking 9 < 5 false
                  checking 3 < 5 so swap (9,3) arr -> 4,3,9,8,5
                  checking 8 < 5 false
    arr -> 4,3,9,8,5 last swap (9,5)
    arr -> 4,3,5,8,9
    pivot -> 5 i.e(2)
    quicksort({4,3,9,8,5},0,1) -> pivot => 3 4<3 false, 3<=3 true swap (4,3) => arr-> 3,4,5,8,9
    quicksort({4,3,9,8,5},3,4) -> pivot => 9 8<9 true, swap(8,8), 9<=9 true swap(9,9) => arr-> 3,4,5,8,9.
    output => 3,4,5,8,9
*/
#include<bits/stdc++.h>
void swap(int *a,int *b)
{
    int temp;
    temp = *a;
    *a = *b;
    *b = temp;
}
int partition_sorted(int arr[],int low,int high){
    int pivot_val = arr[high];
    int j = low-1;
    for(int i=low;i<=high-1;i++)
    {
        if(arr[i]<=pivot_val){
            j++;
            swap(&arr[i],&arr[j]);
        }
    }
    swap(&arr[j+1],&arr[high]);
    return(j+1);
}
int quickSort(int arr[],int low,int high){
    if(low<high){
        int pivot_val = partition_sorted(arr,low,high);
        quickSort(arr,low,pivot_val-1);
        quickSort(arr,pivot_val+1,high);
    }
}
int main(){
    int arr[5]={4,9,3,8,5};
    int n = sizeof(arr)/sizeof(arr[0]);
    quickSort(arr,0,n-1);
    for(int i=0;i<n;i++)
    {
        std::cout<<arr[i]<<" ";
    }
}