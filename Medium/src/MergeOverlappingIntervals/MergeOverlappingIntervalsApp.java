package MergeOverlappingIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervalsApp
{
    public static void main(String[] args) {
        int[][] test = {{1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10}};
        int[][] test2 = {{100, 105}, {1, 104}};
        int[][] test3 = {{89, 90}, {-10, 20}, {-50, 0}, {70, 90}, {90, 91}, {90, 95}};
        int[][] test4 = {{1, 22}, {-20, 30}};
        int[][] test5 = {{2, 3}, {4, 5}, {6, 7}, {1, 10}};
        int[][] test6 = {{20, 21}, {22, 23}, {0, 1}, {3, 4}, {23, 24}, {25, 27}, {5, 6}, {7, 19}};
        List<Integer> testList = new ArrayList<>();

        testList.add(4);
        int i = testList.get(0);

        testList.set(0, 6);

        System.out.println(Arrays.deepToString(mergeOverlappingIntervals2(test6)));
    }

     /*public static Integer[][] mergeOverlappingIntervals(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> listCopy = new ArrayList<>();
        int listCopyRow = 0;

        int listRow = 0;
//        for (int[] row : intervals) {
//            if (list.isEmpty()) {
//                list.add(new ArrayList<>(Arrays.asList(row[0], row[1])));
//            }
//
//            if (row[0] > list.get(listRow).get(1)) {
//                list.add(new ArrayList<>(Arrays.asList(row[0], row[1])));
//                listRow++;
//            }
//
//            if (row[1] > list.get(listRow).get(1)) {
//                int integer = list.get(listRow).get(0);
//                list.set(listRow, new ArrayList<>(Arrays.asList(integer, row[1])));
//            }
//
//            if (row[0] < list.get(listRow).get(0)) {
//                int integer = list.get(listRow).get(1);
//                list.set(listRow, new ArrayList<>(Arrays.asList(row[0], integer)));
//            }
//
//            if (row[0] < list.get(0).get(0)) {
//                list.clear();
//                list.add(new ArrayList<>(Arrays.asList(row[0], row[1])));
//                listRow = 0;
//            }
//        }

        int row = 0;

        while (row < intervals.length) {
            if (list.isEmpty()) {
                list.add(new ArrayList<>(Arrays.asList(intervals[row][0], intervals[row][1])));
            }

            if (intervals[row][0] < list.get(0).get(0)) {
                listCopy = new ArrayList<>(list);
                list.clear();
                list.add(new ArrayList<>(Arrays.asList(intervals[row][0], intervals[row][1])));
                listRow = 0;
            }

            if (intervals[row][0] > listCopy.get(listCopyRow).get(1)) {
                list.add(new ArrayList<>(Arrays.asList(intervals[row][0], intervals[row][1])));
                listCopyRow++;
            }

            if (intervals[row][0] > list.get(listRow).get(1)){
                list.add(new ArrayList<>(Arrays.asList(intervals[row][0], intervals[row][1])));
                listRow++;
            }

            if (intervals[row][1] > list.get(listRow).get(1)){
                int integer = list.get(listRow).get(0);
                list.set(listRow, new ArrayList<>(Arrays.asList(integer, intervals[row][1])));
            }

            if (intervals[row][0] < list.get(listRow).get(0)) {
                int integer = list.get(listRow).get(1);
                list.set(listRow, new ArrayList<>(Arrays.asList(intervals[row][0], integer)));
            }




            row++;
        }

        // the "u -> u" is a lambda expression
        return list.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
    }*/

    public static Integer[][] mergeOverlappingIntervals2(int[][] intervals) {

        List<List<Integer>> list = new ArrayList<>();

        int listRow = 0;

        for (int row = 0; row < intervals.length; row++) {
            if (list.isEmpty()) {
                list.add(new ArrayList<>(Arrays.asList(intervals[row][0], intervals[row][1])));
            }

            if (intervals[row][0] > list.get(listRow).get(1)) {
                list.add(new ArrayList<>(Arrays.asList(intervals[row][0], intervals[row][1])));
                listRow++;
            }

            if (intervals[row][1] > list.get(listRow).get(1)) {
                int integer = list.get(listRow).get(0);
                list.set(listRow, new ArrayList<>(Arrays.asList(integer, intervals[row][1])));
            }

            if (intervals[row][0] < list.get(listRow).get(0)) {
                int integer = list.get(listRow).get(1);
                list.set(listRow, new ArrayList<>(Arrays.asList(intervals[row][0], integer)));
            }

            if (intervals[row][0] < list.get(0).get(0)) {
                list.clear();
                list.add(new ArrayList<>(Arrays.asList(intervals[row][0], intervals[row][1])));
                listRow = 0;
            }
        }

        // the "u -> u" is a lambda expression
        // Converting a bidimensional list to a bidimensional array
        return list.stream().map(u -> u.toArray(new Integer[0])).toArray(Integer[][]::new);
    }
}
