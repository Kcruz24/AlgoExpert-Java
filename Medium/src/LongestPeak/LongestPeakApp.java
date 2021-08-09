package LongestPeak;

public class LongestPeakApp
{
    public static void main(String[] args) {
        int[] array = {1, 3, 2};

        System.out.println(longestPeak(array));
    }
    public static int longestPeak(int[] array) {
        int backward = 1, forward = 1, center = 1, counter = 0, longestPeak = 0;

        while (center < array.length - 1) {

            if (array[center] > array[center - 1] && array[center] > array[center + 1]) {

                while (backward - 1 >= 0 && array[backward - 1] < array[backward]) {
                    counter++;
                    backward--;
                }

                while (forward + 1 < array.length && array[forward + 1] < array[forward]) {
                    counter++;
                    forward++;
                }

                counter += 1;

                if (counter > longestPeak) {
                    longestPeak = counter;
                }

                counter = 0;
            }

            center++;
            backward = center;
            forward = center;
        }

        return longestPeak;
    }
}
