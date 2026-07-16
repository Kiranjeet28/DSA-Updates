import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Find previous smaller for each bar
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Find next smaller for each bar
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate max area using both
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }
}
