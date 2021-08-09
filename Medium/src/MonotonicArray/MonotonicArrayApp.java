package MonotonicArray;

public class MonotonicArrayApp
{
    public static void main(String[] args) {
        int[] array = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};

        System.out.println(isMonotonic(array));

    }

    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        if (array.length == 2) {
            if (array[0] < array[1] || array[0] > array[1])
                return true;
        } else if (array.length == 1 || array.length == 0) {
            return true;
        }

        int idxOne = 0;
        int idxTwo = 1;

        while (idxOne < array.length - 1) {
            int digit1 = array[idxOne];
            int digit2 = array[idxTwo];
            
            if(array[0] > 0) {
                if (digit1 < digit2 || digit1 == digit2) {
                    idxOne++;
                    idxTwo++;
                } else {
                    return false;
                }
            } else if (array[0] < 0) {
                if (digit1 > digit2 || digit1 == digit2) {
                    idxOne++;
                    idxTwo++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
