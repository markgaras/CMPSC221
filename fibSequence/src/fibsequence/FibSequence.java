package fibsequence;

public class FibSequence {

   public static void main(String[] args) {
        int num1 = 1;
        int num2 = 1;
        int num3;
        
        for (int iterations = 0; iterations < 10; iterations++) {
            System.out.println(num1);
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
    }
}