class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low =1;
        int high = position[n-1] - position[0];
        int mid =0;
        int result = 0;
        while(high>=low){
          mid = (high+low)/2;
          if(fit(position,m , mid)){
            result = mid;
            low = mid + 1;
          }else{
            high = mid - 1;
          }
        }
        return result;
    }
    
 public boolean fit(int[] position, int m, int mid){
    int count = 1; // first ball
    int last = position[0];

    for(int i = 1; i < position.length; i++){
        if(position[i] - last >= mid){
            count++;
            last = position[i];
        }
        if(count >= m) return true;
    }
    return false;
}
}
