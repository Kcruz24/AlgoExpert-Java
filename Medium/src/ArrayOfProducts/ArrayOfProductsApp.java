package ArrayOfProducts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOfProductsApp
{
    public static void main(String[] args) {
        int[] array = {5, 1, 4, 2};

        System.out.println(Arrays.toString(arrayOfProducts2(array)));
    }
    public static int[] arrayOfProducts(int[] array) {
        // Write your code here.
        List<Integer> arrayList = new ArrayList<>();
        int product = 1;
        int temp;

        for (int integer : array) {
            arrayList.add(integer);
        }

        for (int i = 0; i < array.length; i++) {
            temp = arrayList.get(0);
            arrayList.remove(0);

            for (int integer : arrayList) {
                product *= integer;
            }

            array[i] = product;
            arrayList.add(temp);
            product = 1;
        }

        return array;
    }

    public static int[] arrayOfProducts2(int[] array) {
        // Write your code here.
        int[] products = new int[array.length];
        int i = 0, j = 0, product = 1, mid = 0;

        while (mid < array.length) {

            while (j - 1 >= 0) {
                product *= array[j - 1];
                j--;
            }

            while (i + 1 < array.length) {
                product *= array[i + 1];
                i++;
            }

            products[mid] = product;

            mid++;
            i = mid;
            j = mid;
            product = 1;
        }

        return products;
    }
}
