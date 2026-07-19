class QuickSort{
    public void quickSort(int arr[]){
        if(arr.length < 2) return; 
        quickSortHelper(arr, 0, arr.length - 1);

    }
    public void quickSortHelper(int arr[], int low, int high){
        if(low >= high) return;
        int pivot = partition(arr, low, high);
        quickSortHelper(arr, low, pivot - 1);
        quickSortHelper(arr, pivot + 1, high);
    }
    public int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    private void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}