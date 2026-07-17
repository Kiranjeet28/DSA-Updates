class Solution {
    public String reverseString(String st) {
        StringBuilder stBuild = new StringBuilder();
        String[] arr = st.trim().split("\\s+");

        for (int i = arr.length - 1; i >= 0; i--) {
            stBuild.append(arr[i]);
            if (i != 0) {
                stBuild.append(" ");
            }
        }

        return stBuild.toString();
    }
}