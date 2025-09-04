class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if (i + 1 < s.length() && value < map.get(s.charAt(i + 1))) {
                sum -= value;  // subtract if a smaller value comes before a larger one
            } else {
                sum += value;  // otherwise add
            }
        }
        return sum;
    }
}
