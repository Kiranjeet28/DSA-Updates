class Solution{
    public void selectionSort(int[] arr){
        for(int i = 0 ; i < arr.length ; i++ ){
            int curr = i;
            for(int j = i+1; j < arr.length ; j++ ){
                if(arr[curr] > arr[j]) curr = j;
            }
            int temp = arr[i];
            arr[i]= arr[curr];
            arr[curr] = temp;
        }
        for(int v = 0 ; v < arr.length ; v++ )
        System.out.println(arr[v]);
    }
    public void main(String[] args){
        int[] arr = {64, 25, 12, 22, 11};
        Solution s = new Solution();
        s.selectionSort(arr);
    }
}