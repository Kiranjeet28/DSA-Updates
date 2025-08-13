class Solution {
    long inversionCount = 0;  // Inversion count store करने के लिए variable

    public void divided(int arr[], int left, int right, int[] temp) {
        System.out.println("divided called: left=" + left + ", right=" + right);
        if (left < right) {
            int mid = (left + right) / 2;
            divided(arr, left, mid, temp);
            divided(arr, mid + 1, right, temp);
            conquer(arr, temp, left, mid + 1, right);
        }
    }

    public void conquer(int arr[], int[] temp, int left, int mid, int right) {
        System.out.println("conquer called: left=" + left + ", mid=" + mid + ", right=" + right);
        int i = left;    // Left subarray का start index
        int j = mid;     // Right subarray का start index
        int k = left;    // Temp array में डालने का index

        while (i < mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversionCount += (mid - i);
            }
        }

        while (i < mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int idx = left; idx <= right; idx++) {
            arr[idx] = temp[idx];
        }

        // Print the current state of the array after conquer
        System.out.print("After conquer [" + left + "," + right + "]: ");
        for (int idx = left; idx <= right; idx++) {
            System.out.print(arr[idx] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int[] temp = new int[arr.length];

        Solution sol = new Solution();
        sol.divided(arr, 0, arr.length - 1, temp);

        System.out.println("Inversion Count = " + sol.inversionCount);
    }
}
