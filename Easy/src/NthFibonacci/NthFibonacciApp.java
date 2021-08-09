package NthFibonacci;

public class NthFibonacciApp
{
    public static void main(String[] args) {
        int n = 8;

        System.out.println(getNthFib(n));
    }


    public static int getNthFib(int n) {
        // Write your code here.

        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return getNthFib(n - 1) + getNthFib(n - 2);
        }
    }
}
