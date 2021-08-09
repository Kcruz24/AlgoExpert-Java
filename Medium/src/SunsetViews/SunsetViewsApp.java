package SunsetViews;

import java.util.*;

public class SunsetViewsApp
{
    public static void main(String[] args) {
        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};
        String direction = "WEST";

       System.out.println(sunsetViews(buildings, direction));
    }

    // My solution optimized
    // O(N) time | O(N) space
    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> viewSunset = new ArrayList<>();
        int outside = 0;

        if (direction.equals("EAST")) {
            for (int building: buildings)
                stack.push(building);

            for (int i = buildings.length - 1; i >= 0; i--) {
                if (stack.peek() > outside) {
                    outside = stack.peek();
                    viewSunset.add(i);
                }

                stack.pop();
            }

            Collections.reverse(viewSunset);
        } else {
            for (int i = buildings.length - 1; i >= 0; i--)
                stack.push(buildings[i]);

            for (int i = 0; i < buildings.length; i++) {
                if (stack.peek() > outside) {
                    outside = stack.peek();
                    viewSunset.add(i);
                }

                stack.pop();
            }
        }

        return viewSunset;
    }

    // This was my first solution
    // O(Nlog(N)) time | O(N) space
    public static ArrayList<Integer> sunsetViews2(int[] buildings, String direction) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> viewSunset = new ArrayList<>();

        if (direction.equals("EAST")) {
            for (int building: buildings)
                stack.push(building);
        } else {
            for (int i = buildings.length - 1; i >= 0; i--)
                stack.push(buildings[i]);
        }

        buildingsWithViews(buildings, stack, viewSunset, direction);

        Collections.sort(viewSunset);

        return viewSunset;
    }

    public static void buildingsWithViews(int[] buildings, Stack<Integer> stack, List<Integer> list, String direction) {
        int outside = 0;

        if (direction.equals("EAST")) {
            for (int i = buildings.length - 1; i > 0; i--) {
                if (stack.peek() > outside) {
                    outside = stack.peek();
                    list.add(i);
                }

                stack.pop();
            }
        } else {
            for (int i = 0; i < buildings.length; i++) {
                if (stack.peek() > outside) {
                    outside = stack.peek();
                    list.add(i);
                }

                stack.pop();
            }
        }

    }
}
