import java.util.*;

public class Main {
    public static List<Integer> divisors(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                result.add(i); 
                if (i != n / i) {
                    result.add(n / i);
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(divisors(6)); 
    }
}
