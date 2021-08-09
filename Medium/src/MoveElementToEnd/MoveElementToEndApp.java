package MoveElementToEnd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoveElementToEndApp
{
    public static void main(String[] args) {

    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

        int start = 0;
        int end = array.size() - 1;

        while (start < end) {
            if (array.get(start) == toMove && array.get(end) != toMove) {
                Collections.swap(array, start, end);
                start++;
                end--;
            }

            if (array.get(start) != toMove) {
                start++;
            }

            if (array.get(start).equals(array.get(end))) {
                end--;
            }
        }
        
        return new ArrayList<>(array);
    }
}
