#include <iostream>
using namespace std;

void insertionSort(int arr[],int n){
    int i,j,key;
    for(i=1;i<n;i++){
        key=arr[i];
        j=i-1;
        while(j>=0 && arr[j]>key){
            arr[j+1]=arr[j];
            j -= 1;
        }
        arr[j+1]=key;
    }
}
int display(int arr[],int n){
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}
int main(){
    int a[]={10,6,4,17,1};
    int n = sizeof(a)/sizeof(int);
    cout<<"Unsorted array: ";
    display(a,n);
    insertionSort(a,n);
    cout<<"Sorted array: ";
    display(a,n);
    return 0;
}