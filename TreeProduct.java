import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            int H = scanner.nextInt();
            if (H == 0)
                break;
            
            int n = (1 << H) - 1; // Number of nodes in the complete binary tree
            long[] values = new long[n];
            
            for (int i = 0; i < n; i++) {
                values[i] = scanner.nextLong();
            }
            
            long[] P = new long[n];
            for (int i = n - 1; i >= 0; i--) {
                int leftChild = 2 * i + 1;
                int rightChild = 2 * i + 2;
                
                if (leftChild >= n) { // Leaf node
                    P[i] = values[i];
                } else {
                    long leftValue = P[leftChild];
                    long rightValue = P[rightChild];
                    P[i] = Math.max(values[i] * leftValue, values[i] * rightValue);
                }
            }
            
            System.out.println(P[0] % 1_000_000_007);
        }
        
      
    }
}